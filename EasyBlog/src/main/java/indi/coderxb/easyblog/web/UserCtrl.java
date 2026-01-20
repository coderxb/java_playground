/**
 * UserCtrl.java   2016年3月8日 下午8:38:44 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.web;

import indi.coderxb.easyblog.bo.UserBo;
import indi.coderxb.easyblog.entity.po.AccountPo;
import indi.coderxb.easyblog.utils.AppResponse;
import indi.coderxb.easyblog.utils.Page;
import indi.coderxb.easyblog.web.model.CreateUserFrom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserCtrl {

    private static Logger log = LoggerFactory.getLogger(UserCtrl.class);

    @Resource
    private UserBo userBo;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView listUser(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            String pageNoParam = request.getParameter("pageNo");
            Integer pageNo = 1;
            if (pageNoParam != null) {
                pageNo = Integer.valueOf(pageNoParam);
            }
            Page<AccountPo> usersPage = userBo.pageUserBy(null, pageNo, 2);
            mv.addObject("page", usersPage);
            mv.setViewName("admin/users");
            return mv;
        } catch (Exception e) {
            log.error("查询用户列表失败", e);
            mv.setViewName("common/error");
        }
        return mv;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView createUserUI(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("admin/create-user");
            return mv;
        } catch (Exception e) {
            log.error("获取后台用户列表失败", e);
            mv.setViewName("common/error");
        }
        return mv;
    }

    @RequestMapping(value = "create/ajaxsave", method = RequestMethod.POST)
    @ResponseBody
    public AppResponse saveCreateUser(@Valid CreateUserFrom createForm, BindingResult result) {
        AppResponse res = new AppResponse(HttpStatus.OK.value());
        if (result.hasErrors()) {
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String, String> data = new HashMap<String, String>();
            for (FieldError fieldError : fieldErrors) {
                data.put(fieldError.getCode(), fieldError.getDefaultMessage());
            }
            res.setMessage("Paramter error!");
            res.setData(data);
            return res;
        }
        try {
            userBo.createUser(createForm);
            res.setMessage("添加用户成功");
        } catch (Exception e) {
            log.error("添加用户记录失败", e);
            res.setStatus(HttpStatus.BAD_REQUEST.value());
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @RequestMapping(value = "create/save", method = RequestMethod.POST)
    public ModelAndView saveCreateUser1(@Valid CreateUserFrom createForm, BindingResult result) {
        ModelAndView mv = new ModelAndView();
        if (result.hasErrors()) {
            mv.setViewName("common/create-user-valid-error");
            return mv;
        }
        try {
            userBo.createUser(createForm);
            List<AccountPo> userList = userBo.listUserBy();
            mv.addObject("userList", userList);
            mv.setViewName("admin/users");
        } catch (Exception e) {
            log.error("添加用户记录失败", e);
            mv.setViewName("common/error");
        }
        return mv;
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView updateUserUI(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            String id = request.getParameter("id");
            AccountPo userPo = userBo.getUserById(id);
            mv.addObject("user", userPo);
            mv.setViewName("admin/update-user");
            return mv;
        } catch (Exception e) {
            log.error("获取更新用户页面", e);
            mv.setViewName("common/error");
        }
        return mv;
    }
}
