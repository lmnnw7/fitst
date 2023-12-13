package com.lh.controller;


import com.lh.pojo.Device;
import com.lh.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RequestMapping("/api/device")
@RestController
public class DeviceController {

    @Autowired(required = false)
    private DeviceService deviceService;

    //通过ID查找设备
    @RequestMapping("/findDeviceByID")
    public ResponseEntity<?> findDeviceByID(@RequestParam Integer id){
        Device device=deviceService.findDeviceByID(id);
        if(device!=null){
            return ResponseEntity.ok(device);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找所有设备
    @RequestMapping("/findAllDevice")
    public ResponseEntity<?> findAllDevice() {
        List<Device> Dlist=deviceService.findAllDevice();
        return ResponseEntity.ok(Dlist);
    }

    //查找可用设备
    @RequestMapping("/findAvailableDevice")
    public ResponseEntity<?> findAvailableDevice() {
        List<Device> Dlist=deviceService.findAvailableDevice();
        return ResponseEntity.ok(Dlist);
    }

    //通过用户ID查找设备
    @RequestMapping("/findDeviceByUID")
    public ResponseEntity<?> findDeviceByUID(@RequestParam Integer user_id) {
        List<Device> deviceList=deviceService.findDeviceByUID(user_id);
        return ResponseEntity.ok(deviceList);
    }

    //添加设备
    @RequestMapping("/addDevice")
    public ResponseEntity<?> addDevice(Device device ,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/FJYL/src/main/resources/static/img/" + fileName;
                file.transferTo(new File(filePath));
                device.setImage_path("../src/img/device/"+fileName);
            }
            int i=deviceService.insertDevice(device);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).build();
        }
    }

    //更新设备
    @RequestMapping("/updateDevice")
    public ResponseEntity<?> updateDevice(Device device,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/FJYL/src/main/resources/static/img/" + fileName;
                file.transferTo(new File(filePath));
                device.setImage_path("../src/img/device/"+fileName);
            }
            int i=deviceService.updateDevice(device);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //根据ID删除设备
    @RequestMapping("/deleteDeviceByID")
    public ResponseEntity<?> deleteDeviceByID(@RequestParam Integer id){
        int i=deviceService.deleteDeviceByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查找设备，模糊查询
    @RequestMapping("/findDeviceByStr")
    public ResponseEntity<?> findDeviceByStr(@RequestParam(value = "searchStr")String searchStr){
        List<Device> deviceList=deviceService.findDeviceByStr(searchStr);
        return ResponseEntity.ok(deviceList);
    }

    //上架设备
    @RequestMapping("/PutOnDevice")
    public ResponseEntity<?> PutOnDevice(@RequestParam Integer id){
        int i=deviceService.updateAvailableTo1(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //下架设备
    @RequestMapping("/PullOffDevice")
    public ResponseEntity<?> PullOffDevice(@RequestParam Integer id){
        int i=deviceService.updateAvailableTo2(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
