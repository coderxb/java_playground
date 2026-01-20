/**
 * IndexAdminCtrl.java   2016年12月29日 下午3:08:37 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.web;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("admin")
public class IndexAdminCtrl {

    private static Logger log = LoggerFactory.getLogger(IndexAdminCtrl.class);

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        try {
            mv.setViewName("admin/index");
            return mv;
        } catch (Exception e) {
            log.error("获取后台Dashboard失败", e);
            mv.setViewName("common/error");
        }
        return mv;
    }

}
