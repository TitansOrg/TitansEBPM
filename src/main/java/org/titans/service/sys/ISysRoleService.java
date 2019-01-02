package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysRoleBean;

public interface ISysRoleService {

    String queryAllSysRoleInfo();

    String queryDetailInfoById(String id);

    void saveOrUpdateSysRoleInfo(SysRoleBean sysRole);

    void removeSysRoleInfo(List<SysRoleBean> sysRole);
}
