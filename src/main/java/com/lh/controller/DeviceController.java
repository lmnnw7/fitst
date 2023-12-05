package com.lh.controller;


import com.lh.pojo.Device;
import com.lh.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
public class DeviceController {

    @Autowired(required = false)
    private DeviceService deviceService;

    @RequestMapping("/findAllDevice")
    public ResponseEntity<?> findAllDevice() {
        List<Device> Dlist=deviceService.findAllDevice();
        return ResponseEntity.ok(Dlist);
    }

    @RequestMapping("/findDeviceByUID")
    public ResponseEntity<?> findDeviceByUID(@RequestParam Integer id) {
        List<Device> Dlist=deviceService.findDeviceByUID(id);
        return ResponseEntity.ok(Dlist);
    }


}
