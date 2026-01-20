/**
 * BzException.java   2015年6月9日 下午11:09:31 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.exception;

public class BzException extends RuntimeException {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 1L;

    public BzException() {
        super();
    }

    public BzException(String msg) {
        super(msg);
    }

    public BzException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
