package org.titans.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysDeptBean;
import org.titans.bean.sys.SysRoleBean;
import org.titans.dao.sys.ISysDeptDao;
import org.titans.service.sys.ISysDeptService;

import com.alibaba.fastjson.JSON;

@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    private ISysDeptDao sysDeptDao;

    @Override
    public List<SysDeptBean> queryAllSysDeptInfo() {

        List<SysDeptBean> list = sysDeptDao.queryAllSysDeptInfo();
        JSON.toJSONString(list);
        return list;
    }

    @Override
    public SysDeptBean queryDetailInfoById(String id) {

        SysDeptBean sysDept = sysDeptDao.queryDetailInfoById(id);
        List<SysRoleBean> roleList = sysDept.getSysRoleList();
        for (int i = 0; i < roleList.size(); i++) {

            SysRoleBean sysRole = roleList.get(i);
            Hibernate.initialize(sysRole);
        }
        return sysDept;
    }

    @Override
    public void saveOrUpdateSysDeptInfo(SysDeptBean sysDept) {

        sysDeptDao.saveOrUpdateSysDeptInfo(sysDept);
    }

    @Override
    public void removeSysDeptInfo(List<SysDeptBean> sysDepts) {

        for (int i = 0; i < sysDepts.size(); i++) {

            sysDeptDao.deleteSysDeptInfo(sysDepts.get(i));
        }
    }

    @Override
    public List<Map<String, String>> getAllDeptInfo() {
        List<Map<String, String>> allDeptInfo = sysDeptDao.getAllDeptInfo();
        JSON.toJSONString(allDeptInfo);
        return allDeptInfo;
    }
}
