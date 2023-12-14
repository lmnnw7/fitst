package com.lh.service.impl;

import com.lh.mapper.EmergencyMapper;
import com.lh.mapper.FavoriteMapper;
import com.lh.pojo.Emergency;
import com.lh.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class EmergencyServiceImpl implements EmergencyService {

    @Autowired(required = false)
    private EmergencyMapper emergencyMapper;

    @Override
    public List<Emergency> findAllEmergency() {
        return emergencyMapper.findAllEmergency();
    }
}
