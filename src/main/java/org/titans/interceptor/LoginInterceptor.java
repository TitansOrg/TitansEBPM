package org.titans.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.sys.SysUserBean;
import org.titans.util.SessionUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {

        // 如果拦截的是方法，查验是否有AuthenPassport注解，如果有注解则需要验证用户是否已登录
        if (handler instanceof HandlerMethod) {

            HandlerMethod method = (HandlerMethod) handler;
            AuthenPassport authPassport = method.getMethodAnnotation(AuthenPassport.class);
            if (authPassport == null || authPassport.validate() == false) {

                return true;
            }
            SysUserBean user = SessionUtil.getCurrentUser(request);
            if (user == null) {

                String head = request.getHeader("x-requested-with"); 
                if(head == null || "".equals(head)) {

                    response.getWriter().write("<script language='javascript'>top.location.href='"
                        + request.getContextPath()+ "/index.jsp'</script>");
                } else {

                    response.getWriter().write("账号未登录，请先登录！");
                }
                return false;
            }
        }
        return true;
    }
}
