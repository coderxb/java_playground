/**
 * UserType.java   2016年12月30日 下午2:26:22 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.enums;

public enum UserType {
    VISITOR("visitor", new Byte("1")), MANAGER("manager", new Byte("2"));

    private String code;
    private Byte val;

    private UserType(String code, Byte val) {
        this.code = code;
        this.val = val;
    }

    public String getCode() {
        return code;
    }

    public Byte getVal() {
        return val;
    }

    public static UserType getUserTypeByCode(String code) {
        if (code == null || code == "") {
            throw new NullPointerException("User type can not empty.");
        }

        for (UserType type : values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Illegal user type value.");
    }
}
