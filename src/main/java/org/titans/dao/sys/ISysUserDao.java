package org.titans.dao.sys;

import java.util.List;

import org.titans.bean.sys.SysDeptBean;
import org.titans.bean.sys.SysUserBean;
import org.titans.core.dao.IBaseDao;

public interface ISysUserDao extends IBaseDao<SysUserBean>{

    SysUserBean querySysUserByCode(String userCode, String password);

    SysUserBean queryDetailInfoById(String id);

    void deleteSysUserInfo(SysUserBean sysUser);
}
