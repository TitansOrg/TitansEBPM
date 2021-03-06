package org.titans.dao.${module};

import java.util.List;

import org.titans.bean.${module}.${className}Bean;

public interface I${className}Dao {

    List<${className}Bean> queryAll${className}Info();

    ${className}Bean queryDetailInfoById(String id);

    void saveOrUpdate${className}Info(${className}Bean ${className?uncap_first});

    void delete${className}Info(${className}Bean ${className?uncap_first});
}
