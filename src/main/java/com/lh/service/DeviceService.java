package com.lh.service;

import com.lh.pojo.Device;

import java.util.List;

public interface DeviceService {
    public Device findDeviceByID(Integer id);//通过ID查找设备
    public List<Device> findDeviceByUID(Integer id);//通过用户ID查找设备
    int deleteDeviceByID(Integer id);//通过ID删除设备
    int updateDevice(Device device);//编辑设备
    List<Device> findDeviceByStr(String searchStr);//模糊查询设备
    List<Device> findAllDevice();//查找所有设备
    int insertDevice(Device device);//添加设备
}
