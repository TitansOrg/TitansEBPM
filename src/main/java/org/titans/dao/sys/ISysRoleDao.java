package org.titans.dao.sys;

import org.titans.bean.sys.SysRoleBean;
import org.titans.core.dao.IBaseDao;

public interface ISysRoleDao extends IBaseDao<SysRoleBean>{

    SysRoleBean queryDetailInfoById(String id);

    void deleteSysRoleInfo(SysRoleBean sysRole);

    SysRoleBean querySysRoleByName(String roleName);
}
