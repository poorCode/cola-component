package com.jd.cola.dto;

/**
 * 单条数据响应
 *
 * @author deer
 * @date 2021-12-13
 */
public class SingleResponse<T> extends Response {
    private T data;

    public static <T> SingleResponse<T> ofSuccess() {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static <T> SingleResponse<T> ofSuccess(T data) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> SingleResponse<T> ofFailure(String errCode, String errMessage) {
        SingleResponse<T> response = new SingleResponse<>();
        response.setSuccess(false).setErrCode(errCode).setErrMessage(errMessage);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
