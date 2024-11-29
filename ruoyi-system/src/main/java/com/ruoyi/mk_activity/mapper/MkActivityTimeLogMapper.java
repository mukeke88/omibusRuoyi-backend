package com.ruoyi.mk_activity.mapper;

import com.ruoyi.mk_activity.domain.MkActivityTimeLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MkActivityTimeLogMapper {
    void insertActivityLog(MkActivityTimeLog log);
}
