package com.lh.service;

import com.lh.pojo.Device;

import java.util.List;

public interface DeviceService {
    public Device findDeviceByID(Integer id);
    public List<Device> findDeviceByUID(Integer id);
    int deleteDeviceByID(Integer id);
    int updateDevice(Device device);
    List<Device> findDeviceByStr(String searchStr);
    List<Device> findAllDevice();
}
