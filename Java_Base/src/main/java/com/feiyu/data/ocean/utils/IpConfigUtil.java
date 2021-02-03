package com.feiyu.data.ocean.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取IP工具类
 * 
 * @author
 *
 */
public class IpConfigUtil {
    
    private static final String DEF_LOCAL_HOST_IP = "127.0.0.1";
    
    private static final Logger logger            = LoggerFactory.getLogger(IpConfigUtil.class);
    
    /**
     * 获取本机名称的方法
     * 
     * @return String
     */
    public static String getLocalName() {
    
        InetAddress ia;
        try {
            ia = InetAddress.getLocalHost();
            
            return ia.getHostName();
        }
        catch (Exception e) {
            logger.error("Exception:", e);
        }
        return "";
    }
    
    /**
     * 获取MAC地址的方法
     * 
     * @return String
     */
    public static String getMACAddress() {
    
        InetAddress ia;
        try {
            ia = InetAddress.getLocalHost();
            // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
            byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
            
            // 下面代码是把mac地址拼装成String
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < mac.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                // mac[i] & 0xFF 是为了把byte转化为正整数
                String s = Integer.toHexString(mac[i] & 0xFF);
                
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            
            // 把字符串所有小写字母改为大写成为正规的mac地址并返回
            return sb.toString().toUpperCase();
        }
        catch (Exception e) {
            logger.error("Exception:", e);
        }
        return "";
    }
    
    private static String getLinuxLocalIp() {
    
        String ip = DEF_LOCAL_HOST_IP;
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                                break;
                                
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            logger.error("获取ip地址异常: ", ex);
            ip = DEF_LOCAL_HOST_IP;
        }
        return ip;
    }
    
    /**
     * autogeneration
     * 
     * @return static
     */
    public static String getLocalIP() {
    
        if (isWindows()) {
            try {
                return InetAddress.getLocalHost().getHostAddress();
            }
            catch (Exception e) {
                logger.error("获取ip地址异常: ", e);
                return DEF_LOCAL_HOST_IP;
            }
        }
        else {
            return getLinuxLocalIp();
        }
    }
    
    private static boolean isWindows() {
    
        return System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1;
    }
    
}
