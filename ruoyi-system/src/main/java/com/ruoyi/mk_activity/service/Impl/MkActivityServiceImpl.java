package com.ruoyi.mk_activity.service.Impl;

import com.ruoyi.mk_activity.domain.MkActivity;
import com.ruoyi.mk_activity.mapper.MkActivityMapper;
import com.ruoyi.mk_activity.service.IMkActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MkActivityServiceImpl implements IMkActivityService {
    @Autowired
    private MkActivityMapper mkActivityMapper;

    @Override
    public void saveActivity(MkActivity activity) {
        mkActivityMapper.saveActivity(activity);
    }

    @Override
    public MkActivity getActivityById(Long id) {
        return mkActivityMapper.getActivityById(id);
    }

    @Override
    public List<MkActivity> getActivities() {
        return mkActivityMapper.getActivities();
    }
}
