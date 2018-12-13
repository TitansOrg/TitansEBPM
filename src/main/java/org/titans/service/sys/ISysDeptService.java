package org.titans.service.sys;

import java.util.List;

import org.titans.bean.sys.SysDeptBean;

public interface ISysDeptService {

    List<SysDeptBean> queryAllSysDeptInfo();

    SysDeptBean queryDetailInfoById(String id);

    void saveOrUpdateSysDeptInfo(SysDeptBean sysDept);

    void removeSysDeptInfo(List<SysDeptBean> sysDept);
}
