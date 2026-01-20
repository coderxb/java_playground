/**
 * QueryBean.java   2016年3月9日 下午5:23:00 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.web.model;

public class QueryBean {

    /**
     * 查询参数-页号
     */
    private Integer pageNo;
    /**
     * 查询参数-每页记录数
     */
    private Integer pageSize;
    /**
     * 查询参数-排序字段
     */
    private String orderBy;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

}
