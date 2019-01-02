package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysUserBean;

public interface ISysUserService {

    String checkUserLogin(String usercode, String password);

    String queryAllSysUserInfo();

    String queryDetailInfoById(String id);

    void saveOrUpdateSysUserInfo(SysUserBean sysUser);

    void removeSysUserInfo(List<SysUserBean> sysUser);
}
