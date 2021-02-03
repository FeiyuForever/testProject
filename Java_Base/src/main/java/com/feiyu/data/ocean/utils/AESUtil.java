package com.feiyu.data.ocean.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @description:  AES 加密算法
 */
public class AESUtil {
    public static String encryptStr(String rawStr, String password) throws Exception {
        byte[] ret = encrypt(rawStr, password);
        return parseByte2HexStr(ret);
    }

    public static String decryptStr(String encryptedStr, String password) throws Exception{
        byte[] ret = decrypt(parseHexStr2Byte(encryptedStr), password);
        return new String(ret);
    }

    /**
     * AES加密字符串
     *
     * @param content  需要被加密的字符串
     * @param password 加密需要的密码
     * @return 密文
     */
    private static byte[] encrypt(String content, String password) throws Exception {
        SecretKeySpec key = getKey(password);
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] byteContent = content.getBytes("utf8");
        byte[] result = cipher.doFinal(byteContent);
        return result;
    }

    /**
     * 解密AES加密过的字符串
     *
     * @param content  AES加密过过的内容
     * @param password 加密时的密码
     * @return 明文
     */
    private static byte[] decrypt(byte[] content, String password) throws Exception{
        SecretKeySpec key = getKey(password);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] result = cipher.doFinal(content);
        return result;
    }

    /**将16进制转换为二进制
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**将二进制转换成16进制
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    private static SecretKeySpec getKey(String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(password.getBytes());
        kgen.init(128, secureRandom);
        //kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        return new SecretKeySpec(enCodeFormat, "AES");
    }

    public static void main(String[] args) {
//        String windId="1025761090";//海底捞
        String windId="1028369235"; //山东新科特电气有限公司 311901288C1F6B0BB2B696DCFF73DCF7
//        String windId="1000295566";//上海名乐亭工贸有限公司07901316F64715035DA8D537D22E12BB
//        String windId = "1047934153";//小米的万得号
//        String windId="1052264747"; //格力
//        String windId="1063106510";//万科
//        String windId="1042970863";//晋城市盛泰和商贸有限公司
//        String windId="1166321512";//江苏道勤置业有限公司
//        String windId="1024736719";//华为
//        String windId="1063106510";//万科
        String encrpytStr = null;
        try {
            encrpytStr = AESUtil.encryptStr(windId, "\"Wind2019*/\"");
            String dStr = AESUtil.decryptStr(encrpytStr,"\"Wind2019*/\"");
            System.out.println(encrpytStr);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
