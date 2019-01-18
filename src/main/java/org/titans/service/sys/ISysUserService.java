package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysUserBean;
import org.titans.core.service.BaseService;

public interface ISysUserService extends BaseService<SysUserBean>{

    String checkUserLogin(String usercode, String password);

    String queryAllSysUserInfo();

    String queryDetailInfoById(String id);

    void removeSysUserInfo(List<SysUserBean> sysUser);
}
