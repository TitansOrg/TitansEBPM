package org.titans.controller.device;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.device.DeviceApplyBean;
import org.titans.service.device.IDeviceApplyService;

@Controller
@RequestMapping(value = "/device")
public class DeviceApplyController {

    private Logger log = LoggerFactory.getLogger(DeviceApplyController.class);

    @Autowired
    private IDeviceApplyService deviceApplyService;

    @AuthenPassport
    @RequestMapping(value = "deviceApplyList")
    public ModelAndView deviceApplyList() {

        return new ModelAndView("device/deviceApplyList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getDeviceApplyList")
    public List<DeviceApplyBean> getDeviceApplyList() {

        List<DeviceApplyBean> list = deviceApplyService.getDeviceApplyList();
        return list;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "deviceApplyDetail")
    public ModelAndView deviceApplyDetail() {

        return new ModelAndView("device/deviceApplyDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public Object queryDetailInfoById(String id) {

        DeviceApplyBean deciveApply = deviceApplyService.queryDeviceApplyById(id);
        return deciveApply;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "deviceApplyReview")
    public ModelAndView deviceApplyReview() {

        return new ModelAndView("device/deviceApplyReview");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody DeviceApplyBean deviceApplyBean) {

        boolean result = true;
        try {

            deviceApplyService.saveDeviceApply(deviceApplyBean);
        } catch (Exception e) {

            log.error("异常信息：" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
}
