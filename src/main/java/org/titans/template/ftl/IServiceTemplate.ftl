package org.titans.service.${module};

import java.util.List;

import org.titans.bean.${module}.${className}Bean;

public interface I${className}Service {

    List<${className}Bean> queryAll${className}Info();

    ${className}Bean queryDetailInfoById(String id);

    void saveOrUpdate${className}Info(${className}Bean ${className?uncap_first});

    void remove${className}Info(List<${className}Bean> ${className?uncap_first});
}
