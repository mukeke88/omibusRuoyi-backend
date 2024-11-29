package com.ruoyi.mk_activity.service;

import com.ruoyi.mk_activity.domain.MkActivity;

import java.util.List;

public interface IMkActivityService {
    int saveActivity(MkActivity activity);

    MkActivity getActivityById(Long id);

    List<MkActivity> getActivities(String activityName);

    boolean checkActivityNameUnique(MkActivity activity);

    int updateActivity(MkActivity activity);

    int deleteActivityByIds(Long[] activityIds);
}
