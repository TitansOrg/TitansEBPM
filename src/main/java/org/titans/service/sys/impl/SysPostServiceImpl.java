package org.titans.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysPostBean;
import org.titans.dao.sys.ISysPostDao;
import org.titans.service.sys.ISysPostService;

@Service
public class SysPostServiceImpl implements ISysPostService {

    @Autowired
    private ISysPostDao sysPostDao;

    @Override
    public List<SysPostBean> queryAllSysPostInfo() {

        return sysPostDao.queryAllSysPostInfo();
    }

    @Override
    public SysPostBean queryDetailInfoById(String id) {

        return sysPostDao.queryDetailInfoById(id);
    }

    @Override
    public void saveOrUpdateSysPostInfo(SysPostBean sysPost) {

        sysPostDao.saveOrUpdateSysPostInfo(sysPost);
    }

    @Override
    public void removeSysPostInfo(List<SysPostBean> sysPosts) {

        for (int i = 0; i < sysPosts.size(); i++) {

            sysPostDao.deleteSysPostInfo(sysPosts.get(i));
        }
    }
}
