package org.titans.dao.sys;

import java.util.List;

import org.titans.bean.sys.SysDeptBean;

public interface ISysDeptDao {

    List<SysDeptBean> queryAllSysDeptInfo();

    SysDeptBean queryDetailInfoById(String id);

    void saveOrUpdateSysDeptInfo(SysDeptBean sysDept);

    void deleteSysDeptInfo(SysDeptBean sysDept);
}
