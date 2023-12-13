package com.lh.service;

import com.lh.pojo.Device;

import java.util.List;

public interface DeviceService {
    Device findDeviceByID(Integer id);//通过ID查找设备
    List<Device> findUserAbleDevice(Integer id);//查找用户未售出设备
    List<Device> findUserUnableDevice(Integer id);//查找用户售出设备
    int deleteDeviceByID(Integer id);//通过ID删除设备
    int updateDevice(Device device);//编辑设备
    List<Device> findDeviceByStr(String searchStr);//模糊查询设备
    List<Device> findAllDevice();//查找所有设备
    List<Device> findAvailableDevice();//查找可用设备
    int insertDevice(Device device);//添加设备
    int updateAvailableTo0(Integer id);//更改可用性为已售出
    int updateAvailableTo1(Integer id);//更改可用性为上架
    int updateAvailableTo2(Integer id);//更改可用性为下架
}
