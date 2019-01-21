package org.titans.service.sys.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysDeptBean;
import org.titans.bean.sys.SysPostBean;
import org.titans.core.service.impl.BaseServiceImpl;
import org.titans.dao.sys.ISysDeptDao;
import org.titans.service.sys.ISysDeptService;

import com.alibaba.fastjson.JSON;

@Service
public class SysDeptServiceImpl extends BaseServiceImpl<SysDeptBean> implements ISysDeptService {

    /*@Autowired*/
    private ISysDeptDao sysDeptDao;

    /**
     * 用set方式注入,为了动态给父类注入dao.
     * 
     */
    @Resource
    public void setInfoDao(ISysDeptDao sysDeptDao) {
        super.setBaseDao(sysDeptDao);
        this.sysDeptDao = sysDeptDao;
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
