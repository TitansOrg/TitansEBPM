package org.titans.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysDeptBean;
import org.titans.bean.sys.SysPostBean;
import org.titans.core.service.impl.BaseServiceImpl;
import org.titans.dao.sys.ISysDeptDao;
import org.titans.dao.sys.ISysPostDao;
import org.titans.service.sys.ISysPostService;

@Service
public class SysPostServiceImpl extends BaseServiceImpl<SysPostBean> implements ISysPostService {

    private ISysPostDao sysPostDao;
    /**
     * 用set方式注入,为了动态给父类注入dao.
     * 
     */
    @Resource
    public void setSysPostDao(ISysPostDao sysPostDao) {
        super.setBaseDao(sysPostDao);
        this.sysPostDao = sysPostDao;
    }

    @Override
    public SysPostBean queryDetailInfoById(String id) {

        return sysPostDao.queryDetailInfoById(id);
    }

    @Override
    public void removeSysPostInfo(List<SysPostBean> sysPosts) {

        for (int i = 0; i < sysPosts.size(); i++) {

            sysPostDao.deleteSysPostInfo(sysPosts.get(i));
        }
    }
}
