package org.titans.service.sys;

import java.util.List;
import java.util.Map;

import org.titans.bean.sys.SysDeptBean;
import org.titans.core.service.BaseService;

public interface ISysDeptService extends BaseService<SysDeptBean> {

    SysDeptBean queryDetailInfoById(String id);

    void removeSysDeptInfo(List<SysDeptBean> sysDept);

    List<Map<String, String>> getAllDeptInfo();

}
