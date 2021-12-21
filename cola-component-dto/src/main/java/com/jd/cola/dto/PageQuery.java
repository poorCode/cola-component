package com.jd.cola.dto;

/**
 * page query
 *
 * @author deer
 * @date 2021-12-13
 */
public abstract class PageQuery implements Query {
    private static final long serialVersionUID = 1L;

    /**
     * 升序标识
     */
    private static final String ASC = "ASC";

    /**
     * 降序标识
     */
    private static final String DESC = "DESC";

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

    /**
     * 排序字段
     */
    private String orderBy;

    /**
     * 排序方向，默认降序
     */
    private String orderDirection = DESC;

    /**
     * 分组字段
     */
    private String groupBy;

    /**
     * 是否需要统计总数
     */
    private boolean needTotalCount = true;

    public int getPageIndex() {
        return this.pageIndex;
    }

    public PageQuery setPageIndex(int pageIndex) {
        this.pageIndex = Math.max(pageIndex, 1);
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageQuery setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return (getPageIndex() - 1) * getPageSize();
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageQuery setOrderBy(String orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public PageQuery setOrderDirection(String orderDirection) {
        if (ASC.equalsIgnoreCase(orderDirection) || DESC.equalsIgnoreCase(orderDirection)) {
            this.orderDirection = orderDirection;
        }
        return this;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }
}
