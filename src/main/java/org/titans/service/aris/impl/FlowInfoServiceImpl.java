package org.titans.service.aris.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.aris.ArisGroupAttrBean;
import org.titans.bean.aris.ArisGrouptblBean;
import org.titans.bean.aris.ModelAttrBean;
import org.titans.bean.aris.ModelBean;
import org.titans.dao.aris.IFlowInfoDao;
import org.titans.service.aris.IFlowInfoService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * ARIS数据同步模块服务层接口实现类.
 */
@Service("flowInfoServiceImpl")
public class FlowInfoServiceImpl implements IFlowInfoService {
    /**
     * 日志对象.
     */
    private static Logger log = Logger.getLogger(FlowInfoServiceImpl.class);

    /**
     * 注入数据同步功能持久层对象.
     */
    @Autowired
    private IFlowInfoDao flowInfoDao;

    @Override
    public String queryEbpmModelBean(String modelId) {

        ModelBean modelBean = flowInfoDao.queryEbpmModelBean(modelId);
        return JSON.toJSONString(modelBean, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public List<Map<String, String>> queryModelDetailInfo(String modelGuid) {

        String symbolType = "99999999";
        return flowInfoDao.queryModelDetailInfo(modelGuid, symbolType);
    }

    @Override
    public List<Map<String, String>> queryObjDetailInfo(String objGuid, String objType) {

        return flowInfoDao.queryObjDetailInfo(objGuid, objType);
    }

    @Override
    public Map<String, String> queryFileRootPath() {

        Map<String, String> map = new HashMap<String, String>();
        ArisGrouptblBean arisGrouptbl = flowInfoDao.queryGrouptblById("rootgroup:20:s");
        map.put("id", arisGrouptbl.getId());
        Set<ArisGroupAttrBean> set = arisGrouptbl.getArisGroupAttrBeans();
        Iterator<ArisGroupAttrBean> iter = set.iterator();
        while (iter.hasNext()) {

            ArisGroupAttrBean attr = iter.next();
            if (attr.getAttrtypenum() == 1) {

                map.put("name", attr.getPlaintextfragment());
                break;
            }
        }
        map.put("isParent", "true");
        return map;
    }

    @Override
    public List<Map<String, String>> queryFileInfoByParentId(String parentId) {

        List<Map<String, String>> result = new ArrayList<>();
        List<ArisGrouptblBean> arisGrouptbl = flowInfoDao.queryGrouptblByParentId(parentId);
        for (int i = 0; i < arisGrouptbl.size(); i++) {

            Map<String, String> map = new HashMap<>();
            ArisGrouptblBean grouptbl = arisGrouptbl.get(i);
            map.put("id", grouptbl.getId());
            map.put("isParent", "true");
            Set<ArisGroupAttrBean> set = grouptbl.getArisGroupAttrBeans();
            Iterator<ArisGroupAttrBean> iter = set.iterator();
            while (iter.hasNext()) {

                ArisGroupAttrBean attr = iter.next();
                if (attr.getAttrtypenum() == 1) {

                    map.put("name", attr.getPlaintextfragment());
                    break;
                }
            }
            result.add(map);
        }
        List<ModelBean> models = flowInfoDao.queryModelByGroupId(parentId);
        for (int i = 0; i < models.size(); i++) {

            Map<String, String> map = new HashMap<>();
            ModelBean model = models.get(i);
            map.put("id", model.getId());
            map.put("isParent", "false");
            Set<ModelAttrBean> set = model.getModelAttrBeans();
            Iterator<ModelAttrBean> iter = set.iterator();
            while (iter.hasNext()) {

                ModelAttrBean attr = iter.next();
                if (attr.getAttrtypenum() == 1) {

                    map.put("name", attr.getPlaintextfragment());
                    break;
                }
            }
            result.add(map);
        }
        return result;
    }
}
