/**
 * UserBoTest.java   2016年3月10日 下午4:09:01 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.bo;

import indi.coderxb.easyblog.BaseTest;
import indi.coderxb.easyblog.entity.po.AccountPo;
import indi.coderxb.easyblog.enums.Sex;
import indi.coderxb.easyblog.enums.UserType;
import indi.coderxb.easyblog.utils.GsonUtil;
import indi.coderxb.easyblog.utils.Page;
import indi.coderxb.easyblog.web.model.CreateUserFrom;
import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserBoTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(UserBoTest.class);

    @Resource
    private UserBo userBo;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPageUserBy() {
        AccountPo userPo = new AccountPo();
        userPo.setName("xiaoli1");
        Page<AccountPo> page = userBo.pageUserBy(userPo, 1, 9);
        log.debug("Page result = {}", GsonUtil.toJson(page));
    }

    @Test
    @Ignore
    public void testCreateUser() {
        CreateUserFrom createForm = new CreateUserFrom();

        for (int i = 0; i < 100; i++) {
            createForm.setAddress("北京北京");
            createForm.setEmail("xiaoli00000" + i + "@gmail.com");
            createForm.setEnName("xiaoli00000" + i);
            createForm.setName("小李00000" + i);
            createForm.setPassword("123456");
            createForm.setSex(Sex.MALE.getCode());
            createForm.setType(UserType.VISITOR.getCode());
            createForm.setWebsite("http://www.baidu.com");
            userBo.createUser(createForm);
        }
    }

}
