package com.feiyu.data.ocean.controller.base;

/**
 * @Author xzhou.James
 * @Date 2019/12/8  14:42
 */
import java.io.Serializable;

public class ReponseEntity<T> implements Serializable {

    private int errorCode = 100;
    private String errorMessage ;
    private int status;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }
    public ReponseEntity codeError(CodeUtils.ResposeCode errorCode, String errorMessage) {
        this.errorCode = errorCode.getCode();
        this.errorMessage = errorMessage;
        return this;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public T getData() {
        return data;
    }
    public ReponseEntity data(T data) {
        this.data = data;
        return this;
    }
    public static ReponseEntity getErrorResponse(CodeUtils.ResposeCode errorCode, String errorMessage){
        ReponseEntity reponseEntity = new ReponseEntity();
        return reponseEntity.codeError(errorCode, errorMessage);
    }
    public static <T> ReponseEntity getSuccessResponseWithData(T data){
        ReponseEntity reponseEntity = new ReponseEntity<T>();
        return reponseEntity.data(data);
    }
    public static ReponseEntity getSuccessResponse(){
        ReponseEntity reponseEntity = new ReponseEntity();
        return reponseEntity;
    }
}

