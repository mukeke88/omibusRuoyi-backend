package com.ruoyi.web.controller.mk_activity;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.mk_activity.domain.MkActivity;
import com.ruoyi.mk_activity.service.IMkActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mk-activity")
public class MkActivityController extends BaseController {
    @Autowired
    private IMkActivityService activityService;

    @PostMapping("/start")
    public AjaxResult startActivity(@RequestBody MkActivity activity) {
        activity.setStartTime(LocalDateTime.now());
        activityService.saveActivity(activity);
        return AjaxResult.success();
    }

    @PutMapping("/end/{id}")
    public AjaxResult endActivity(@PathVariable Long id) {
        MkActivity activity = activityService.getActivityById(id);
        if (activity != null) {
            activity.setEndTime(LocalDateTime.now());
            activityService.saveActivity(activity);
            return AjaxResult.success();
        }
        return AjaxResult.success();
    }

    @GetMapping("/get-activities")
    public TableDataInfo getActivities() {
        startPage();
        List<MkActivity> activities = activityService.getActivities();
        return getDataTable(activities);
    }
}

