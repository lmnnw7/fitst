package com.lh.service.impl;

import com.lh.mapper.DeviceMapper;
import com.lh.pojo.Device;
import com.lh.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service//服务类，优先使用
@Primary
public class DeviceServiceImpl implements DeviceService {

    @Autowired(required = false)
    private DeviceMapper deviceMapper;

    @Override
    public Device findDeviceByID(Integer id) {
        return deviceMapper.findDeviceByID(id);
    }

    @Override
    public List<Device> findDeviceByUID(Integer id) {
        return deviceMapper.findDeviceByUID(id);
    }

    @Override
    public int deleteDeviceByID(Integer id) {
        return deviceMapper.deleteDeviceByID(id);
    }

    @Override
    public int updateDevice(Device device) {
        return deviceMapper.updateDevice(device);
    }

    @Override
    public List<Device> findDeviceByStr(String searchStr) {
        return deviceMapper.findDeviceByStr(searchStr);
    }

    @Override
    public List<Device> findAllDevice() {
        return deviceMapper.findAllDevice();
    }

    @Override
    public List<Device> findAvailableDevice() {
        return deviceMapper.findAvailableDevice();
    }

    @Override
    public int insertDevice(Device device) {
        return deviceMapper.insertDevice(device);
    }

    @Override
    public int updateAvailableTo0(Integer id) {
        return deviceMapper.updateAvailableTo0(id);
    }

    @Override
    public int updateAvailableTo1(Integer id) {
        return deviceMapper.updateAvailableTo1(id);
    }

    @Override
    public int updateAvailableTo2(Integer id) {
        return deviceMapper.updateAvailableTo2(id);
    }
}
