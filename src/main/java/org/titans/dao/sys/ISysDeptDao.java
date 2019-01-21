package org.titans.dao.sys;

import java.util.List;
import java.util.Map;

import org.titans.bean.sys.SysDeptBean;
import org.titans.core.dao.IBaseDao;

public interface ISysDeptDao extends IBaseDao<SysDeptBean>{

    void deleteSysDeptInfo(SysDeptBean sysDept);

    List<Map<String, String>> getAllDeptInfo();
}
