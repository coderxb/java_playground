/**
 * CheckParamUtil.java   2016年2月1日 下午2:45:09 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.math.BigInteger;
import java.security.InvalidParameterException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckParamUtil {

    public static final String URI_PATTERN = "^/[0-9a-zA-Z\\-/\\.%\\?#&]*";
    public static final String DOMAIN_PATTERN = "[a-z0-9A-Z\\-\\.]*";

    public static final String LBSNAME_PATTERN = "^[\u4e00-\u9fa50-9a-zA-Z\\-.\\_\\@#]+";

    public static final String PASSWORD_PATTERN = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*()_+=-]).{6,16}";

    public static final String IP_CIDR_PATTERN = "((?:((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))/([1-9]|[1-2][0-9]|3[0-2]))$)|(0\\.0\\.0\\.0/0)";

    public static final String RDS_ADMINNAME_PATTERN = "[0-9a-zA-Z]+";

    /**
     * 检查字段是否为null或者是否为空
     *
     * @param value
     * @param fieldName
     */
    public static void checkNotEmpty(Object value, String fieldName) {
        if (value == null) {
            throw new NullPointerException("This is paramter[" + fieldName + "] is null");
        }
        if (value instanceof String) {
            if (((String) value).trim().length() == 0) {
                //throw new IllegalArgumentException(s)
                throw new InvalidParameterException("This is paramter[" + fieldName + "] is invalid.");
            }
        }
    }

    /**
     * 检查字段的长度是否符合最大值
     *
     * @param value
     * @param maxLength
     * @param fieldName
     */
    public static void checkMaxLength(String value, int maxLength, String fieldName) {
        if (value != null) {
            if (value.length() > maxLength) {
                throw new InvalidParameterException("Invalid Paramter:the length of " + fieldName
                    + " can not be larger than " + maxLength + ".");
            }
        }
    }

    /**
     * 检查字段的长度是否符合要求
     *
     * @param value
     * @param minLength
     * @param maxLength
     * @param fieldName
     */
    public static void checkLength(String value, int minLength, int maxLength, String fieldName) {
        if (value != null) {
            if (value.trim().length() > maxLength) {
                throw new InvalidParameterException("Invalid Paramter:the length of " + fieldName
                    + " can not be larger than " + maxLength + ".");
            }
            if (value.trim().length() < minLength) {
                throw new InvalidParameterException("Invalid Paramter:the length of " + fieldName
                    + " can not be small than " + minLength + ".");
            }
        }
    }

    /**
     * 检查字段的大小是否符合要求
     *
     * @param value
     * @param minValue
     * @param maxValue
     * @param fieldName
     */
    public static void checkValue(String value, int minValue, int maxValue, String fieldName) {
        if (value != null) {
            int intValue = 0;
            try {
                intValue = Integer.parseInt(value);
            } catch (Exception e) {
                throw new InvalidParameterException("Invalid Paramter " + fieldName);
            }
            if (intValue > maxValue) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be larger than " + maxValue + ".");
            }
            if (intValue < minValue) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be less than " + minValue + ".");
            }
        }
    }

    /**
     * 检查字段的大小是否符合要求
     *
     * @param value
     * @param minValue
     * @param maxValue
     * @param fieldName
     */
    public static void checkValue(String value, int minValue, BigInteger maxValue, String fieldName) {
        if (value != null) {
            int intValue = 0;
            try {
                intValue = Integer.parseInt(value);
            } catch (Exception e) {
                throw new InvalidParameterException("Invalid Paramter " + fieldName);
            }
            if (((BigInteger) maxValue).compareTo(new BigInteger(value)) == -1) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be larger than " + maxValue + ".");
            }
            if (intValue < minValue) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be less than " + minValue + ".");
            }
        }
    }

    /**
     * 检查字段的值是否符合最大值要求
     *
     * @param value
     * @param maxValue
     * @param fieldName
     */
    public static void checkMaxValue(Long value, long maxValue, String fieldName) {
        if (value != null) {
            if (value > maxValue) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be larger than " + maxValue + ".");
            }
        }
    }

    /**
     * 检查字段的值是否符合最小值要求
     *
     * @param value
     * @param minValue
     * @param fieldName
     */
    public static void checkMinValue(Long value, long minValue, String fieldName) {
        if (value != null) {
            if (value < minValue) {
                throw new InvalidParameterException("Invalid Paramter:the value of " + fieldName
                    + " can not be less than " + minValue + ".");
            }
        }
    }

    public static void checkUri(String value, String fieldName) {
        Pattern p = Pattern.compile(URI_PATTERN);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

    public static void checkLbsName(String value, String fieldName) {
        Pattern p = Pattern.compile(LBSNAME_PATTERN);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

    public static void checkDomain(String value, String fieldName) {
        Pattern p = Pattern.compile(DOMAIN_PATTERN);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

    /**
     * 检查字段是否等于规定值
     *
     * @param srcValue
     * @param dstValue
     * @param fieldName
     */
    public static void checkEqualsValue(String srcValue, String dstValue, String fieldName) {
        if (srcValue.equals(dstValue)) {
            throw new InvalidParameterException("Invalid Paramte " + fieldName);
        }
    }

    public static void checkIpAddress(String ip, String fieldName) {
        Pattern p = Pattern.compile(IP_CIDR_PATTERN);
        Matcher m = p.matcher(ip);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

    public static void checkRdsAdminName(String value, String fieldName) {
        Pattern p = Pattern.compile(RDS_ADMINNAME_PATTERN);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

    public static void checkPassword(String value, String fieldName) {
        Pattern p = Pattern.compile(PASSWORD_PATTERN);
        Matcher m = p.matcher(value);
        if (!m.matches()) {
            throw new InvalidParameterException("Invalid Parameter " + fieldName);
        }
    }

}
