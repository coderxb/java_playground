/**
 * AppException.java   2015年6月9日 下午10:55:19 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.exception;

public class AppException extends RuntimeException {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    public AppException() {
        super();
    }

    public AppException(String msg) {
        super(msg);
    }

    public AppException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
