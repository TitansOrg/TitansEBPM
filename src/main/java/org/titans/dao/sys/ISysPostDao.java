package org.titans.dao.sys;

import java.util.List;

import org.titans.bean.sys.SysPostBean;

public interface ISysPostDao {

    List<SysPostBean> queryAllSysPostInfo();

    SysPostBean queryDetailInfoById(String id);

    void saveOrUpdateSysPostInfo(SysPostBean sysPost);

    void deleteSysPostInfo(SysPostBean sysPost);
}
