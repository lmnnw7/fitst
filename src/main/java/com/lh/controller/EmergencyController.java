package com.lh.controller;

import com.lh.pojo.Emergency;
import com.lh.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    //通过ID查找紧急设备
    @RequestMapping("/findEmergencyByID")
    public ResponseEntity<?> findNewsByID(@RequestParam Integer id){
        Emergency emergency=emergencyService.findEmergencyByID(id);
        if(emergency!=null){
            return ResponseEntity.ok(emergency);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //根据ID删除紧急设备
    @RequestMapping("/deleteEmergencyByID")
    public ResponseEntity<?> deleteEmergencyByID(@RequestParam Integer id){
        int i=emergencyService.deleteEmergencyByID(id);
        if(i>0){
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //更新紧急设备
    @RequestMapping("/updateEmergency")
    public ResponseEntity<?> updateEmergency(@RequestBody Emergency emergency){
        if(emergency!=null){
            int i=emergencyService.updateEmergency(emergency);
            return ResponseEntity.ok(i);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //查询紧急设备，模糊查询
    @RequestMapping("/findEmergencyByStr")
    public ResponseEntity<?> findEmergencyByStr(@RequestParam(value="searchStr") String searchStr){
        List<Emergency> EmergencyList=emergencyService.findEmergencyByStr(searchStr);
        return ResponseEntity.ok(EmergencyList);
    }

    //添加紧急设备
    @RequestMapping("/addEmergency")
    public ResponseEntity<?> addEmergency(@RequestBody Emergency emergency) {
        if (emergency!=null){
            int i=emergencyService.insertEmergency(emergency);
            return ResponseEntity.ok(i);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
