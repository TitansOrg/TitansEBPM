package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysPostBean;

public interface ISysPostService {

    List<SysPostBean> queryAllSysPostInfo();

    SysPostBean queryDetailInfoById(String id);

    void saveOrUpdateSysPostInfo(SysPostBean sysPost);

    void removeSysPostInfo(List<SysPostBean> sysPost);
}
