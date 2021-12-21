package com.jd.cola.dto;

import java.util.Collection;
import java.util.Collections;

/**
 * 多条数据响应
 *
 * @author deer
 * @date 2021-12-13
 */
public class MultiResponse<T> extends Response {

    private Collection<T> data;

    public static <T> MultiResponse<T> ofSuccess() {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(true);
        return response;
    }

    public static <T> MultiResponse<T> ofSuccess(Collection<T> data) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> MultiResponse<T> ofFailure(String errCode, String errMessage) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(false).setErrCode(errCode).setErrMessage(errMessage);
        return response;
    }

    public boolean isEmpty() {
        return this.getData() == null || this.getData().size() == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
