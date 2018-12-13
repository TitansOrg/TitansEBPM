package org.titans.controller.sys;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.sys.SysUserBean;
import org.titans.service.sys.ISysUserService;
import org.titans.util.SessionUtil;

/**
 * 用户登录.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 用户登录.
     * @param usercode 账号
     * @param password 密码
     * @return 登录结果
     */
    @ResponseBody
    @RequestMapping(value = "login")
    public boolean login(HttpServletRequest request, String usercode, String password) {

        boolean result = false;
        SysUserBean user = sysUserService.checkUserLogin(usercode, password);
        if (user == null) {

            result = false;
        } else {

            SessionUtil.setAttr(request, SessionUtil.CURR_USER_INFO, user);
            result = true;
        }
        return result;
    }

    /**
     * 用户登录.
     * @param usercode 账号
     * @param password 密码
     * @return 登录结果
     */
    @RequestMapping(value = "loginOut")
    public String loginOut(HttpServletRequest request) {

        SessionUtil.removeAttr(request, SessionUtil.CURR_USER_INFO);
        return "forward:/index.jsp";
    }
    /**
     * 
     * @param request
     * @return
     */
    @AuthenPassport
    @RequestMapping(value = "mainPage")
    public ModelAndView mainPage(HttpServletRequest request) {

        return new ModelAndView("mainPage");
    }
}
