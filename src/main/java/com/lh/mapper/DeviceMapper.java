package com.lh.mapper;

import com.lh.pojo.Device;

import java.util.List;

public interface DeviceMapper {
    List<Device> findAllDevice();
    public Device findDeviceByID(Integer id);
    public List<Device> findDeviceByUID(Integer id);
    int deleteDeviceByID(Integer id);
    int updateDevice(Device device);
    List<Device> findDeviceByStr(String searchStr);
}
