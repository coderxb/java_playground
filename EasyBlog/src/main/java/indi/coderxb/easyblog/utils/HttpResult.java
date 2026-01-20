/**
 * HttpResult.java   2016年1月21日 下午7:17:34 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

public class HttpResult {

    private Integer status;
    private String message;

    public HttpResult() {
        // do nothing
    }

    public HttpResult(Integer status) {
        this.status = status;
    }

    public HttpResult(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HttpResult [status=" + status + ", message=" + message + "]";
    }

}
