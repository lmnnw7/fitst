package com.lh.service;

import com.lh.pojo.Emergency;
import com.lh.pojo.Emergency;

import java.util.List;

public interface EmergencyService {
    List<Emergency> findAllEmergency();//查找所有紧急设备
    Emergency findEmergencyByID(Integer id);//通过ID查找紧急设备
    int deleteEmergencyByID(Integer id);//通过ID删除紧急设备
    int updateEmergency(Emergency emergency);//编辑紧急设备
    List<Emergency> findEmergencyByStr(String searchStr);//模糊查询紧急设备
    int insertEmergency(Emergency emergency);//添加紧急设备
}
