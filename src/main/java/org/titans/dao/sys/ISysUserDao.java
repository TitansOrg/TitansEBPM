package org.titans.dao.sys;

import java.util.List;

import org.titans.bean.sys.SysUserBean;

public interface ISysUserDao {

    SysUserBean querySysUserByCode(String userCode, String password);

    List<SysUserBean> queryAllSysUserInfo();

    SysUserBean queryDetailInfoById(String id);

    void saveOrUpdateSysUserInfo(SysUserBean sysUser);

    void deleteSysUserInfo(SysUserBean sysUser);
}
