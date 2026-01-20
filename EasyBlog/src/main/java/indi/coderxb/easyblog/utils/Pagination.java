/**
 * Pagination.java   2015年6月8日 上午11:55:40 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    /**
     * 数据总行数
     */
    private int totalCount;

    /**
     * 每页行数
     */
    private int pageSize = 10;

    /**
     * 当前页码
     */
    private int currentPage = 1;

    /**
     * 上一页页码
     */
    private int nextPage;

    /**
     * 下一页页码
     */
    private int previousPage;

    /**
     * 总页数
     */
    private int totalPageCount;

    /**
     * 是否有下一页
     */
    private boolean hasNext;

    /**
     * 是否有前一页
     */
    private boolean hasPrevious;

    /**
     * 当前页开始行数
     */
    private int pageStartRow;

    /**
     * 显示出来的页码数量
     */
    private int showPageNum = 5;

    /**
     * 要显示的页码
     */
    private List<Integer> pageList = new ArrayList<Integer>();

    /**
     * 当前页结束行数
     */
    private int pageEndRow;

    public Pagination() {
    }

    public Pagination(int totalRows, int currentPage) {
        new Pagination(totalRows, currentPage, this.pageSize);
    }

    public Pagination(int totalRows, int currentPage, int pageSzie) {
        if (pageSize > 0) {
            this.setPageSize(pageSzie);
        }
        setTotalCount(totalRows);
        setCurrentPage(currentPage);
        calPageList();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        if (totalCount % pageSize == 0) {
            totalPageCount = totalCount / pageSize;
        } else {
            totalPageCount = totalCount / pageSize + 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int pCurrentPage) {

        // 如果请求的当前页大于总页数,则把最后一页作为当前页
        if (pCurrentPage > totalPageCount) {
            pCurrentPage = totalPageCount;
        }

        if (pCurrentPage <= 0) {
            pCurrentPage = 1;
        }

        this.currentPage = pCurrentPage;

        this.previousPage = currentPage - 1;

        this.nextPage = currentPage + 1;

        // 计算当前页开始行和结束行
        if (currentPage * pageSize < totalCount) {

            // 先计算结束行，然后用结束页推算前一页
            pageEndRow = currentPage * pageSize;
            pageStartRow = pageEndRow - pageSize + 1;
        } else {
            pageEndRow = totalCount;
            pageStartRow = pageSize * (totalPageCount - 1) + 1;
        }

        if (pageStartRow < 1) {
            pageStartRow = 1;
        }

        // 是否存在前页和后页
        if (nextPage > totalPageCount) {
            hasNext = false;
        } else {
            hasNext = true;
        }
        if (previousPage <= 0) {
            hasPrevious = false;
        } else {
            hasPrevious = true;
        }
    }

    public List<Integer> calPageList() {
        pageList = new ArrayList<Integer>();
        if (currentPage < showPageNum) {
            for (int i = 1; i <= (totalPageCount > showPageNum ? showPageNum : totalPageCount); i++) {
                pageList.add(i);
            }
        } else {
            int beginPage = currentPage - (showPageNum % 2 == 0 ? showPageNum / 2 - 1 : showPageNum / 2);
            int endPage = currentPage + showPageNum / 2;
            if (beginPage > 1 && endPage <= totalPageCount) {
                for (int i = beginPage; i <= endPage; i++) {
                    pageList.add(i);
                }
            } else if (endPage > totalPageCount) {
                for (int i = totalPageCount - showPageNum + 1; i <= totalPageCount; i++) {
                    pageList.add(i);
                }
            }
        }
        return pageList;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public List<Integer> getPageList() {
        return pageList;
    }

    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    public static void main(String[] args) {
        System.out.print("总页数：\t");
        System.out.println(10);
        for (int i = 1; i <= 10; i++) {
            Pagination pageBean = new Pagination(50, i, 5);
            System.out.print("当前页为第" + i + "页：\t");
            System.out.println(pageBean.getPageList());
        }
    }
}
