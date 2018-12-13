package org.titans.dao.sys;

import java.util.List;

import org.titans.bean.sys.SysRoleBean;

public interface ISysRoleDao {

    List<SysRoleBean> queryAllSysRoleInfo();

    SysRoleBean queryDetailInfoById(String id);

    void saveOrUpdateSysRoleInfo(SysRoleBean sysRole);

    void deleteSysRoleInfo(SysRoleBean sysRole);
}
