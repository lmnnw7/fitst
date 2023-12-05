package com.lh.controller;


import com.lh.pojo.Device;
import com.lh.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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

    @RequestMapping("/addDevice")
    public ResponseEntity<?> addDevice(@RequestBody Device device,@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/Plane/src/main/webapp/img/" + fileName;
                file.transferTo(new File(filePath));
                device.setImage_path("");
            }
            int i=deviceService.updateDevice(device);
            return ResponseEntity.ok(i);
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @RequestMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
        try{
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String filePath = "D:/ideawork/FJYL/src/main/resources/static/img/" + fileName;
                file.transferTo(new File(filePath));
                System.out.println("111");
            }
            return ResponseEntity.ok("888");
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getImage")
    public ResponseEntity<Resource> getImage(){
//        Device device1=new Device();
//        Resource resource = new ClassPathResource(device.getImage_path());
        Resource resource = new ClassPathResource("static/img/pla106_01_pic.jpg");
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
    }

}
