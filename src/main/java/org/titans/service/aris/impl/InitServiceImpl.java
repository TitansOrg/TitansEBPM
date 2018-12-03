package org.titans.service.aris.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.dao.aris.IInitDao;
import org.titans.service.aris.IInitService;

@Service("initServiceImpl")
public class InitServiceImpl implements IInitService {

    @Autowired
    private IInitDao initDao;
    @Override
    public Map<Integer, String> queryAttrs() {

        return initDao.queryAttrs();
    }
    @Override
    public Map<String, Integer> queryAttrTypeNum() {

        return initDao.queryAttrTypeNum();
    }

}
