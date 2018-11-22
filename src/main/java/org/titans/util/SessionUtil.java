package org.titans.util;

import javax.servlet.http.HttpServletRequest;

import org.titans.bean.sys.SysUserBean;

/**
 * session tools.
 */
public class SessionUtil {

    public final static String CURR_USER_INFO = "curr_user_info";

    /**
     * 设置session属性值.
     * @param request 请求对象
     * @param key 属性key
     * @param value 属性值
     */
    public static void setAttr(HttpServletRequest request, String key, Object value) {

        request.getSession(true).setAttribute(key, value);
    }

    /**
     * 获取session属性值.
     * @param request 请求对象
     * @param key 属性key
     * @return 属性对象
     */
    public static Object getAttr(HttpServletRequest request, String key) {

        return request.getSession(true).getAttribute(key);
    }

    /**
     * 删除session属性值.
     * @param request 请求对象
     * @param key 属性key
     */
    public static void removeAttr(HttpServletRequest request, String key) {

        request.getSession(true).removeAttribute(key);
    }

    /**
     * 获取当前登录用户信息.
     * @param request 请求对象
     * @return 用户对象
     */
    public static SysUserBean getCurrentUser(HttpServletRequest request) {

        SysUserBean user = (SysUserBean) getAttr(request, CURR_USER_INFO);
        return user;
    }
}

