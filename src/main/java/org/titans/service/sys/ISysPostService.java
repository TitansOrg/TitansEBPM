package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysPostBean;
import org.titans.core.service.BaseService;

public interface ISysPostService extends BaseService<SysPostBean> {

    SysPostBean queryDetailInfoById(String id);

    void removeSysPostInfo(List<SysPostBean> sysPost);
}
