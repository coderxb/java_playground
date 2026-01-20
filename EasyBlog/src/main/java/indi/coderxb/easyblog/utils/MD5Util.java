/**
 * MD5Util.java   2016年1月26日 下午2:25:48 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.security.MessageDigest;

public class MD5Util {

    public static String md5Encode(String data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(data.getBytes("UTF-8"));
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(MD5Util.md5Encode("kingfile"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
