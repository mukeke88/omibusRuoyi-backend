package com.ruoyi.mk_activity.service;

import com.ruoyi.mk_activity.domain.MkActivity;

import java.util.List;

public interface IMkActivityService {
    void saveActivity(MkActivity activity);

    MkActivity getActivityById(Long id);

    List<MkActivity> getActivities();
}
