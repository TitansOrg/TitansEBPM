package org.titans.service.dao;

import java.io.Serializable;
import java.util.List;

import org.titans.bean.device.DeviceApplyBean;

public interface IDeviceApplyDao {

    List<DeviceApplyBean> queryDeviceApplyList();

    DeviceApplyBean queryDeviceApplyById(Serializable id);

    Serializable saveDeviceApp(DeviceApplyBean deviceApplyBean);

    void updateDeviceApply(DeviceApplyBean deviceApplyBean);
}
