package org.titans.controller.${module};

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.${module}.${className}Bean;
import org.titans.service.${module}.I${className}Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "/${function}")
public class ${className}Controller {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(${className}Controller.class);

    @Autowired
    private I${className}Service ${className?uncap_first}Service;

    @AuthenPassport
    @RequestMapping(value = "${className?uncap_first}List")
    public ModelAndView ${className?uncap_first}List() {
        
        return new ModelAndView("${module}/${function}/${className?uncap_first}List");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "get${className}List")
    public List<${className}Bean> get${className}List() {

        List<${className}Bean> list = ${className?uncap_first}Service.queryAll${className}Info();
        return list;
    }

    @AuthenPassport
    @RequestMapping(value = "${className?uncap_first}Detail")
    public ModelAndView ${className?uncap_first}Detail(HttpServletRequest request) {

        return new ModelAndView("${module}/${function}/${className?uncap_first}Detail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public ${className}Bean queryDetailInfoById(String id) {

        ${className}Bean bean = ${className?uncap_first}Service.queryDetailInfoById(id);
        return bean;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody ${className}Bean ${className?uncap_first}) {

        boolean result = true;
        try {

            ${className?uncap_first}Service.saveOrUpdate${className}Info(${className?uncap_first});
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(${className?uncap_first}) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "removeData")
    public boolean removeData(String ids) {

        boolean result = true;
        try {

            List<${className}Bean> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseArray(ids);
            for (int i=0; i< jsonArray.size(); i++) {

                ${className}Bean bean = new ${className}Bean();
                bean.setId(new Long(jsonArray.getString(i)));
                list.add(bean);
            }
            ${className?uncap_first}Service.remove${className}Info(list);
        } catch (Exception e) {

            log.error("删除数据" + JSON.toJSONString(ids) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
}
