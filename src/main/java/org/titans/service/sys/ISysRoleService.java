package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysRoleBean;
import org.titans.core.service.BaseService;

public interface ISysRoleService extends BaseService<SysRoleBean> {

    String queryAllSysRoleInfo();

    String queryDetailInfoById(String id);

    void removeSysRoleInfo(List<SysRoleBean> sysRole);
}
