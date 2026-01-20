/**
 * Constant.java   2015年6月11日 下午8:21:36 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2015 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

public class Constant {

    /**
     * 验证规则
     */
    public final static String DIGITS = "^\\d+$";
    public final static String DOUBLE = "\\d+(\\.\\d+)?";
    public final static String ORIGINIPS = "(((2[0-4]\\d|25[0-5]|1\\d\\d|0|[1-9]\\d?)\\.){3}(2[0-4]\\d|25[0-5]|1\\d\\d|0|[1-9]\\d?)((,|\\||;)((2[0-4]\\d|25[0-5]|1\\d\\d|0|[1-9]\\d?)\\.){3}(2[0-4]\\d|25[0-5]|1\\d\\d|0|[1-9]\\d?))*)";
    public final static String DOMAIN = "((\\.?([A-Za-z0-9\\-_])+([A-Za-z0-9\\-_\\.])*\\.[A-Za-z]{2,})+)";
    public final static String CIDR = "^(([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d?\\d|2[0-4]\\d|25[0-5])\\/(\\d{1}|[0-2]{1}\\d{1}|3[0-2])$";
    public static final String ISEMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";//是否是邮件        
    public static final String ISMOBILE = "^(13|15|17|14|18)[0-9]{9}$";//是否是手机 
    public static final String PASSWORD = "^(?=.*\\d)(?=.*[A-Z])([a-zA-Z0-9]|[!-/\\^\\?@_~`]){6,16}$";//密码验证
}
