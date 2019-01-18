package org.titans.dao.sys;

import org.titans.bean.sys.SysPostBean;
import org.titans.core.dao.IBaseDao;

public interface ISysPostDao extends IBaseDao<SysPostBean>{

    SysPostBean queryDetailInfoById(String id);

    void deleteSysPostInfo(SysPostBean sysPost);
}
