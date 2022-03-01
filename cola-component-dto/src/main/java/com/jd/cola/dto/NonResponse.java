package com.jd.cola.dto;

/**
 * 无数据响应
 *
 * @author deer
 * @date 2021-12-14
 */
public class NonResponse extends Response {
    private static final long serialVersionUID = 1L;

    public static NonResponse ofSuccess() {
        NonResponse response = new NonResponse();
        response.setSuccess(true);
        return response;
    }

    public static NonResponse ofFailure(String errCode, String errMessage) {
        NonResponse response = new NonResponse();
        response.setSuccess(false).setErrCode(errCode).setErrMessage(errMessage);
        return response;
    }
}
