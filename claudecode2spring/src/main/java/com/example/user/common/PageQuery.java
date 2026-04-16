package com.example.user.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("分页基础参数")
public class PageQuery {

    private static final long DEFAULT_PAGE_NUM = 1L;
    private static final long DEFAULT_PAGE_SIZE = 10L;
    private static final long MAX_PAGE_SIZE = 100L;

    @ApiModelProperty(value = "页码，从1开始", example = "1")
    private Long pageNum = DEFAULT_PAGE_NUM;

    @ApiModelProperty(value = "每页条数，最大100", example = "10")
    private Long pageSize = DEFAULT_PAGE_SIZE;

    public long safePageNum() {
        return pageNum == null || pageNum < 1 ? DEFAULT_PAGE_NUM : pageNum;
    }

    public long safePageSize() {
        if (pageSize == null || pageSize < 1) {
            return DEFAULT_PAGE_SIZE;
        }
        return Math.min(pageSize, MAX_PAGE_SIZE);
    }
}
