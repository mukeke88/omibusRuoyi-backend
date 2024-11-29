package com.ruoyi.mk_activity.mapper;

import com.ruoyi.mk_activity.domain.MkActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MkActivityMapper {

    int saveActivity(MkActivity activity);

    MkActivity getActivityById(Long id);

    List<MkActivity> getActivities(String activityName);

    int checkActivityNameUnique(String activityName);

    int updateActivity(MkActivity activity);

    int deleteActivityByIds(Long[] activityIds);
}
