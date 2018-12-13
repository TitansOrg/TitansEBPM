package org.titans.service.${module}.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.${module}.${className}Bean;
import org.titans.dao.${module}.I${className}Dao;
import org.titans.service.${module}.I${className}Service;

@Service
public class ${className}ServiceImpl implements I${className}Service {

    @Autowired
    private I${className}Dao ${className?uncap_first}Dao;

    @Override
    public List<${className}Bean> queryAll${className}Info() {

        return ${className?uncap_first}Dao.queryAll${className}Info();
    }

    @Override
    public ${className}Bean queryDetailInfoById(String id) {

        return ${className?uncap_first}Dao.queryDetailInfoById(id);
    }

    @Override
    public void saveOrUpdate${className}Info(${className}Bean ${className?uncap_first}) {

        ${className?uncap_first}Dao.saveOrUpdate${className}Info(${className?uncap_first});
    }

    @Override
    public void remove${className}Info(List<${className}Bean> ${className?uncap_first}s) {

        for (int i = 0; i < ${className?uncap_first}s.size(); i++) {

            ${className?uncap_first}Dao.delete${className}Info(${className?uncap_first}s.get(i));
        }
    }
}
