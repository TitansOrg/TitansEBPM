package org.titans.service.sys;

import org.titans.bean.sys.SysUserBean;

public interface ISysUserService {

    SysUserBean checkUserLogin(String usercode, String password);
}
