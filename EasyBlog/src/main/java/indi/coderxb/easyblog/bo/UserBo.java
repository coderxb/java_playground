/**
 * UserBo.java   2016年3月8日 下午8:40:24 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.bo;

import indi.coderxb.easyblog.entity.po.AccountPo;
import indi.coderxb.easyblog.entity.po.AccountPoExample;
import indi.coderxb.easyblog.enums.Sex;
import indi.coderxb.easyblog.enums.UserType;
import indi.coderxb.easyblog.mapper.AccountPoMapper;
import indi.coderxb.easyblog.utils.BeanMapUtil;
import indi.coderxb.easyblog.utils.MD5Util;
import indi.coderxb.easyblog.utils.Page;
import indi.coderxb.easyblog.web.model.CreateUserFrom;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

@Service
public class UserBo {

    @Resource
    private AccountPoMapper mapper;

    public Page<AccountPo> pageUserBy(AccountPo userPo, Integer pageNo, Integer pageSize) {
        Page<AccountPo> page = new Page<AccountPo>(pageNo, pageSize);
        AccountPoExample example = queryBeanByUserPo(userPo);
        int totalRecord = mapper.countByExample(example);
        page.setTotalRecord(totalRecord);
        example.setOrderByClause("id desc LIMIT " + page.getOffset() + ", " + pageSize);
        List<AccountPo> userList = mapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(userList)) {
            page.setData(userList);
        }
        Map<String, Object> queryBean = BeanMapUtil.convertBean(userPo);
        page.setQueryParam(queryBean);
        return page;
    }

    public List<AccountPo> listUserBy() {
        return listUserBy(null);
    }

    public List<AccountPo> listUserBy(AccountPo userPo) {
        AccountPoExample example = queryBeanByUserPo(userPo);
        return mapper.selectByExample(example);
    }

    public AccountPoExample queryBeanByUserPo(AccountPo userPo) {
        if (userPo == null) {
            return new AccountPoExample();
        }
        AccountPoExample example = new AccountPoExample();
        AccountPoExample.Criteria qb = example.createCriteria();
        if (!StringUtils.isEmpty(userPo.getName())) {
            qb.andNameEqualTo(userPo.getName());
        }
        return example;
    }

    public Integer createUser(CreateUserFrom createForm) {
        if (StringUtils.isEmpty(createForm.getEmail())) {
            throw new NullPointerException("Email is null.");
        }
        AccountPo record = new AccountPo();
        record.setEmail(createForm.getEmail());
        record.setPassword(MD5Util.md5Encode(createForm.getPassword()));
        record.setEnName(createForm.getEnName());
        record.setName(createForm.getName());
        record.setType(UserType.getUserTypeByCode(createForm.getType()).getVal());
        record.setSex(Sex.getSexVal(createForm.getSex()).getVal());
        record.setWebsite(createForm.getWebsite());
        record.setPosition(createForm.getAddress());
        return mapper.insertSelective(record);
    }

    public AccountPo getUserById(String id) {
        if (id == null || id == "") {
            throw new NullPointerException("User id can not empty!");
        }
        AccountPo user = mapper.selectByPrimaryKey(Integer.valueOf(id));
        return user;
    }
}
