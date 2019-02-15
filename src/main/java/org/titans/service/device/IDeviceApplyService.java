package org.titans.service.device;

import java.util.List;

import org.titans.bean.device.DeviceApplyBean;

public interface IDeviceApplyService {

    List<DeviceApplyBean> getDeviceApplyList();

    void saveDeviceApply(DeviceApplyBean deviceApplyBean);

    DeviceApplyBean queryDeviceApplyById(String processBusinessKey);

    void updateDeviceApply(DeviceApplyBean deviceApply);
}
