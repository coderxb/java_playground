/**
 * AccountVo.java   2016年3月8日 下午8:09:53 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.entity.vo;

import indi.coderxb.easyblog.entity.po.AccountPo;


public class AccountVo extends AccountPo {

    public AccountVo() {
        //TODO do nothing
    }

    public AccountVo(AccountPo accountPo) {
        this.setCreateTime(accountPo.getCreateTime());
        this.setEmail(accountPo.getEmail());
        this.setEnName(accountPo.getEnName());
        this.setId(accountPo.getId());
        this.setIsvalid(accountPo.getIsvalid());
        this.setName(accountPo.getName());
        this.setPassword(accountPo.getPassword());
        this.setPosition(accountPo.getPosition());
        this.setSex(accountPo.getSex());
        this.setVersion(accountPo.getVersion());
        this.setWebsite(accountPo.getWebsite());
    }

}
