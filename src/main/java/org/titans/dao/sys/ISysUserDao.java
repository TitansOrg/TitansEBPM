package org.titans.dao.sys;

import org.titans.bean.sys.SysUserBean;

public interface ISysUserDao {

    SysUserBean querySysUserByCode(String userCode, String password);
}
