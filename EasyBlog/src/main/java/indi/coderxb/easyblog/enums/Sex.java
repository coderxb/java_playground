/**
 * Sex.java   2016年12月30日 上午11:40:15 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.enums;

public enum Sex {

    MALE("male", new Byte("1")), FEMALE("female", new Byte("2"));

    private String code;
    private Byte val;

    private Sex(String code, Byte val) {
        this.code = code;
        this.val = val;
    }

    public String getCode() {
        return code;
    }

    public Byte getVal() {
        return val;
    }

    public static Sex getSexVal(String code) {
        if (code == null || code == "") {
            throw new NullPointerException("Sex value can not empty.");
        }
        for (Sex sex : values()) {
            if (sex.getCode().equals(code)) {
                return sex;
            }
        }
        throw new IllegalArgumentException(code + "is illegal Sex value.");
    }
}
