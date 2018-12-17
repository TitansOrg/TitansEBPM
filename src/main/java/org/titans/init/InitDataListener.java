package org.titans.init;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;
import org.titans.service.aris.IInitService;

/**
 * 容器加载后初始化数据
 * @author xuxk
 *
 */
public class InitDataListener implements InitializingBean, ServletContextAware {

    //获取特性列表key:类型号value：名称
    public static Map<Integer, String> attrMap = new HashMap<Integer, String>();

    //获取特性列表key:名称value：类型号
    public static Map<String, Integer> attrTypeNumMap = new HashMap<String, Integer>();

    @Autowired
    private IInitService initService;
    @Override
    public void setServletContext(ServletContext arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        attrMap = initService.queryAttrs();
        attrTypeNumMap = initService.queryAttrTypeNum();
    }

}
