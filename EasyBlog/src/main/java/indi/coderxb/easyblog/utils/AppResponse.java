/**
 * AppResponse.java   2016年2月17日 上午10:23:28 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.util.UUID;

public class AppResponse {

    private String reqId;
    private Integer status;
    private String message;
    private Object data;

    public AppResponse() {
        this.reqId = UUID.randomUUID().toString();
    }

    public AppResponse(String reqId) {
        this.reqId = reqId;
    }

    public AppResponse(String reqId, Integer status) {
        this.reqId = reqId;
        this.status = status;
    }

    public AppResponse(Integer status) {
        this.reqId = UUID.randomUUID().toString();
        this.status = status;
    }

    public AppResponse(Integer status, String message) {
        this.reqId = UUID.randomUUID().toString();
        this.status = status;
        this.message = message;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this);
    }
}
