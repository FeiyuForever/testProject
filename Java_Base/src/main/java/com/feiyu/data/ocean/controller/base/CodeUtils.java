package com.feiyu.data.ocean.controller.base;

/**
 * @Author xzhou.James
 * @Date 2019/12/8  14:41
 */
public class CodeUtils {//枚举类型 状态码
    public enum ResposeCode {
        NO_ERROR(100),
        ERROR_401(401),
        ERROR_402(402),
        ERROR_200(200);
        private final int code;
        private ResposeCode(int code)
        {
            this.code = code;
        }
        public int getCode() {
            return code;
        }
    }
}
