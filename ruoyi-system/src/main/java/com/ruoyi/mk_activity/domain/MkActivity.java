package com.ruoyi.mk_activity.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MkActivity  extends BaseEntity {
    private Long id;
    private String activityName;
    private Date startTime;
    private Date pauseTime;
    private String description;
    private String status;
    private Date createTime;
    private Date updateTime;
    private Integer totalTime;
}
