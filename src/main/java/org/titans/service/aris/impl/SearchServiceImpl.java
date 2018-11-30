package org.titans.service.aris.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.aris.ModelAttrBean;
import org.titans.bean.aris.ModelBean;
import org.titans.dao.aris.ISearchDao;
import org.titans.service.aris.ISearchService;

@Service("searchServiceImpl")
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private ISearchDao searchDao;
    @Override
    public List<Map<String, String>> queryAllFileInfo(String keyWord) {

        List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
        List<ModelAttrBean> modelAttrIds = searchDao.queryModelIds(keyWord);
        List<String> modelIds = new ArrayList<String>();
        for(ModelAttrBean modelAttr : modelAttrIds) {

            modelIds.add(modelAttr.getParentitemid());
        }
        if (modelIds!=null && modelIds.size() > 0) {
            
            List<ModelBean> modelAttrs = searchDao.queryAllFileInfo(modelIds);
            for(ModelBean model : modelAttrs) {
                Map<String, String> map = new HashMap<String, String>();
                map.put("modelId", model.getId());
                Set<ModelAttrBean> modelAttrBeans = model.getModelAttrBeans();
                for(ModelAttrBean modelAttr:modelAttrBeans){
                    //模型ID
                    if(modelAttr.getAttrtypenum() == Long.valueOf("1")) {
                        //名称
                        map.put("name", modelAttr.getPlaintextfragment());
                    } else if(modelAttr.getAttrtypenum() == Long.valueOf("55")) {
                        //标识符
                        map.put("id", modelAttr.getPlaintextfragment());
                    } else if(modelAttr.getAttrtypenum() == Long.valueOf("1379029")) {
                        //版本
                        map.put("version", modelAttr.getPlaintextfragment());
                    }
                }
                
                returnList.add(map);
            }
        }
        return returnList;
    }

}
