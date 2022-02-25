package com.jd.cola.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 * 分条数据响应
 *
 * @author deer
 * @date 2021-12-13
 */
public class PageResponse<T> extends Response implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 总条数
     */
    private long totalCount = 0;

    /**
     * 每页条数，默认为10
     */
    private static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 每页条数
     */
    private int pageSize = DEFAULT_PAGE_SIZE;

    /**
     * 页标
     */
    private int pageIndex = 1;

    private Collection<T> data;

    public static <T> PageResponse<T> ofSuccess(int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setPageIndex(pageIndex).setPageSize(pageSize).setTotalCount(0);
        return response;
    }

    public static <T> PageResponse<T> ofSuccess(Collection<T> data, int pageIndex, int pageSize, long totalCount) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(true);
        response.setData(data);
        response.setPageIndex(pageIndex).setPageSize(pageSize).setTotalCount(totalCount);
        return response;
    }

    public static <T> PageResponse<T> ofFailure(String errCode, String errMessage) {
        PageResponse<T> response = new PageResponse<>();
        response.setSuccess(false).setErrCode(errCode).setErrMessage(errMessage);
        return response;
    }

    public boolean isEmpty() {
        return this.getData() == null || this.getData().size() == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public long getTotalCount() {
        return totalCount;
    }

    public PageResponse<T> setTotalCount(long totalCount) {
        this.totalCount = Math.max(totalCount, 0);
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageResponse<T> setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        return this;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public PageResponse<T> setPageIndex(int pageIndex) {
        this.pageIndex = Math.max(pageIndex, 1);
        return this;
    }

    public Collection<T> getData() {
        return data;
    }

    public void setData(Collection<T> data) {
        this.data = data;
    }
}
