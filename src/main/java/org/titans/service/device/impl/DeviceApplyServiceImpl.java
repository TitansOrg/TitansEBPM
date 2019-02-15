package org.titans.service.device.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.device.DeviceApplyBean;
import org.titans.service.dao.IDeviceApplyDao;
import org.titans.service.device.IDeviceApplyService;
import org.titans.service.workflow.IWorkflowService;

@Service
public class DeviceApplyServiceImpl implements IDeviceApplyService {

    @Autowired
    private IDeviceApplyDao deviceApplyDao;

    @Autowired
    private IWorkflowService workflowService;

    @Override
    public List<DeviceApplyBean> getDeviceApplyList() {

        return deviceApplyDao.queryDeviceApplyList();
    }

    @Override
    public void saveDeviceApply(DeviceApplyBean deviceApplyBean) {

        Serializable id = deviceApplyDao.saveDeviceApp(deviceApplyBean);
        Map<String, Object> param = new HashMap<>();
        param.put("businessKey", id);
        ProcessInstance processInstance = workflowService.startProcessInstance("helloworld", param);
        deviceApplyBean = deviceApplyDao.queryDeviceApplyById(id);
        deviceApplyBean.setProcessId(processInstance.getId());
        deviceApplyDao.updateDeviceApply(deviceApplyBean);
    }

    @Override
    public DeviceApplyBean queryDeviceApplyById(String processBusinessKey) {

        return deviceApplyDao.queryDeviceApplyById(processBusinessKey);
    }

    @Override
    public void updateDeviceApply(DeviceApplyBean deviceApply) {

        deviceApplyDao.updateDeviceApply(deviceApply);
    }
}
