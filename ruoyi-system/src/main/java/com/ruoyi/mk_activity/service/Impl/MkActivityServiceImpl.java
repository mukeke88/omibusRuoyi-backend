package com.ruoyi.mk_activity.service.Impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.mk_activity.domain.MkActivity;
import com.ruoyi.mk_activity.mapper.MkActivityMapper;
import com.ruoyi.mk_activity.service.IMkActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MkActivityServiceImpl implements IMkActivityService {
    @Autowired
    private MkActivityMapper mkActivityMapper;

    @Override
    public int saveActivity(MkActivity activity) {
        return mkActivityMapper.saveActivity(activity);
    }

    @Override
    public MkActivity getActivityById(Long id) {
        return mkActivityMapper.getActivityById(id);
    }

    @Override
    public List<MkActivity> getActivities(String activityName) {
        return mkActivityMapper.getActivities(activityName);
    }

    @Override
    public boolean checkActivityNameUnique(MkActivity activity) {
        int result = mkActivityMapper.checkActivityNameUnique(activity.getActivityName());
        if (result > 0)
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    @Override
    public int updateActivity(MkActivity activity) {
        return  mkActivityMapper.updateActivity(activity);
    }

    @Override
    public int deleteActivityByIds(Long[] activityIds) {
        return mkActivityMapper.deleteActivityByIds(activityIds);
    }

    @Override
    public boolean startActivity(Long id) {
        MkActivity activity = mkActivityMapper.getActivityById(id);
        if (activity == null || "active".equals(activity.getStatus())) {
            throw new ServiceException("Activity not found or already active");
        }
        activity.setStatus("active");
        activity.setStartTime(new Date());
        activity.setPauseTime(null); //重置以不存数据库
        activity.setTotalTime(null); //重置以不存数据库
        return mkActivityMapper.updateActivity(activity) > 0;
    }

    @Override
    public boolean pauseActivity(Long id) {
        MkActivity activity = mkActivityMapper.getActivityById(id);
        if (activity == null || "paused".equals(activity.getStatus())) {
            throw new ServiceException("Activity not found or already paused");
        }
        activity.setStatus("paused");long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - activity.getStartTime().getTime()) / 1000; // Calculate time in seconds
        activity.setTotalTime(activity.getTotalTime() + (int) elapsedTime);
        activity.setPauseTime(new Date());
        activity.setStartTime(null);//重置以不存数据库
        return mkActivityMapper.updateActivity(activity) > 0;
    }
}
