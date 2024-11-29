package com.ruoyi.mk_activity.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MkActivityTimeLog {
    private Long id;
    private Long activityId;
    private String actionType; // "start" or "pause"
    private Date actionTime;
}
