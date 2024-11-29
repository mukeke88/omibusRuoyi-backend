package com.ruoyi.mk_activity.service.Impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
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
}
