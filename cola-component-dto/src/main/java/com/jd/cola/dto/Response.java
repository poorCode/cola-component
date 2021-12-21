package com.jd.cola.dto;

/**
 * @author deer
 * @date 2021-12-13
 */
public abstract class Response implements DTO {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMessage;


    public boolean isSuccess() {
        return success;
    }

    public Response setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getErrCode() {
        return errCode;
    }

    public Response setErrCode(String errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public Response setErrMessage(String errMessage) {
        this.errMessage = errMessage;
        return this;
    }
}
