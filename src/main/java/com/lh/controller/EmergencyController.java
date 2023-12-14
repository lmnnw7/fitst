package com.lh.controller;

import com.lh.pojo.Device;
import com.lh.pojo.Emergency;
import com.lh.service.DeviceService;
import com.lh.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/emergency")
@RestController
public class EmergencyController {

    @Autowired(required = false)
    private EmergencyService emergencyService;

    //查找所有设备
    @RequestMapping("/findAllEmergency")
    public ResponseEntity<?> findAllEmergency() {
        List<Emergency> emergencyList=emergencyService.findAllEmergency();
        return ResponseEntity.ok(emergencyList);
    }
}
