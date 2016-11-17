package com.controller;

import com.model.UserInfo;
import com.service.facade.IServiceFacade;
import com.util.common.UtilTool;
import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by sniper on 2016/3/19.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);
    @Autowired
    private IServiceFacade serviceFacade;

    @RequestMapping(value = "/doLogin.do")
    public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse response, ModelMap mp) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        log.info("==============="+"".isEmpty());
        if (UtilTool.isEmpty(username) || UtilTool.isEmpty(password)) {
            log.error("参数错误！！");
        }

        boolean logged = false;
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        logged = serviceFacade.getUserService().doLogin(userInfo);

        List<UserInfo> list = serviceFacade.getUserService().getUserList();

        return new ModelAndView("index", mp);
    }
}
