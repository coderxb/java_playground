/**
 * Page.java   2016年3月9日 下午3:10:30 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Page<T> {

    /**
     * 页码-默认是第一页
     */
    private Integer pageNo = 1;
    /**
     * 查询数据库的偏移量 -等于(页码-1)*每页显示的记录数
     */
    private Integer offset = 0;
    /**
     * 每页显示的记录数-默认10条
     */
    private Integer pageSize = 10;
    /**
     * 总记录数
     */
    private Integer totalRecord;
    /**
     * 页面显示页号的尺寸
     */
    private Integer showPageNoSize = 10;
    /**
     * 页面显示页号的开始数
     */
    private Integer showPageNoBegin = 1;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 当前页的记录信息
     */
    private List<T> data;
    /**
     * 查询数据的参数
     */
    private Map<String, Object> queryParam = new HashMap<String, Object>();

    public Page(Integer pageNo, Integer pageSize) {
        if (pageNo < 1) {
            throw new IllegalArgumentException("PageNo[" + pageNo + "] can not negative number or zero.");
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public Page(Integer pageNo, Integer pageSize, Integer showPageNoSize) {
        if (pageNo < 1) {
            throw new IllegalArgumentException("PageNo[" + pageNo + "] can not negative number or zero.");
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.showPageNoSize = showPageNoSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getOffset() {
        this.offset = (this.getPageNo() - 1) * this.getPageSize();
        return offset;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
        int totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize : totalRecord / pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public Integer getShowPageNoSize() {
        return showPageNoSize;
    }

    public void setShowPageNoSize(Integer showPageNoSize) {
        this.showPageNoSize = showPageNoSize;
    }

    public Integer getShowPageNoBegin() {
        if (this.pageNo <= this.showPageNoSize / 2) {
            return showPageNoBegin;
        }
        if (this.totalPage < this.showPageNoSize) {
            return showPageNoBegin;
        }
        Integer remainderPageNum = this.totalPage - this.pageNo;
        if (remainderPageNum < this.showPageNoSize) {
            return this.totalPage - this.showPageNoSize + 1;
        } else {
            return this.pageNo - (this.showPageNoSize / 2 - 1);
        }
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, Object> getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(Map<String, Object> queryParam) {
        this.queryParam = queryParam;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }

}
