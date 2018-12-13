package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysUserBean;

public interface ISysUserService {

    SysUserBean checkUserLogin(String usercode, String password);

    List<SysUserBean> queryAllSysUserInfo();

    SysUserBean queryDetailInfoById(String id);

    void saveOrUpdateSysUserInfo(SysUserBean sysUser);

    void removeSysUserInfo(List<SysUserBean> sysUser);
}
