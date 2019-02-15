package org.titans.service.workflow.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.titans.bean.device.DeviceApplyBean;
import org.titans.service.device.IDeviceApplyService;
import org.titans.service.workflow.IWorkflowStatusService;
import org.titans.util.SpringUtil;

public class WorkflowStatusServiceImpl implements IWorkflowStatusService {

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        if (execution instanceof ExecutionEntity) {

            IDeviceApplyService deviceApplyService = SpringUtil.getSpringContext().getBean(IDeviceApplyService.class);
            String businessKey = (String) execution.getVariable("businessKey");
            ExecutionEntity executionEntity = (ExecutionEntity) execution;
            String status = executionEntity.getCurrentActivityName();
            DeviceApplyBean deviceApply = deviceApplyService.queryDeviceApplyById(businessKey);
            deviceApply.setStatus(status);
            deviceApplyService.updateDeviceApply(deviceApply);
        }
    }
}
