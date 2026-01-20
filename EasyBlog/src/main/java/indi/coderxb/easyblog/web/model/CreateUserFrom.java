/**
 * CreateUserFrom.java   2016年3月29日 下午6:11:08 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.web.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 创建用户表单
 *
 * @ClassName CreateUserFrom
 * @Description TODO
 *
 * @author lixuebing@kingsoft.com
 * @date 2016年3月29日 下午6:17:16
 */
public class CreateUserFrom implements Serializable {

    private static final long serialVersionUID = 3943079795240204712L;

    @Email(message = "邮箱格式错误")
    private String email;

    @NotEmpty(message = "user password is not empty!")
    @Length(min = 6, max = 12, message = "用户密码必须在6~12之间!")
    //@Pattern(regexp = CheckParamUtil.PASSWORD_PATTERN, message = "用户密码不可以为空")
    private String password;

    @NotEmpty(message = "user confirm password is not empty!")
    @Length(min = 6, max = 12, message = "用户密码必须在6~12之间!")
    //@Pattern(regexp = CheckParamUtil.PASSWORD_PATTERN, message = "用户密码不可以为空")
    private String confirmpwd;

    @NotEmpty(message = "{user.id.null}")
    @Length(min = 6, max = 12, message = "用户密码必须在6~12之间!")
    private String name;

    private String enName;

    private String type;

    private String sex;

    private String website;

    private String address;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConfirmpwd() {
        return confirmpwd;
    }

    public void setConfirmpwd(String confirmpwd) {
        this.confirmpwd = confirmpwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
