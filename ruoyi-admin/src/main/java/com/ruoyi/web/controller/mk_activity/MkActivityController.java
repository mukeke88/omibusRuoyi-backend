package com.ruoyi.web.controller.mk_activity;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mk_activity.domain.MkActivity;
import com.ruoyi.mk_activity.service.IMkActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/mk-activity")
public class MkActivityController extends BaseController {
    @Autowired
    private IMkActivityService activityService;

    @GetMapping("/get-activities")
    public TableDataInfo getActivities(@RequestParam(value = "activityName", required = false) String activityName) {
        startPage();
        List<MkActivity> activities = activityService.getActivities(activityName);
        return getDataTable(activities);
    }

    @GetMapping(value = "/{id}")
    public AjaxResult getActivity(@PathVariable Long id)
    {
        return success(activityService.getActivityById(id));
    }

    /**
     * 新增行为
     */
    @PostMapping
    public AjaxResult add(@RequestBody MkActivity activity)
    {
        if (!activityService.checkActivityNameUnique(activity))
        {
            return error("新增行为'" + activity.getActivityName() + "'失败，行为名称已存在");
        }
        return toAjax(activityService.saveActivity(activity));
    }

    @PutMapping
    public AjaxResult update(@RequestBody MkActivity activity) {
        return toAjax(activityService.updateActivity(activity));
    }

    @DeleteMapping
    public AjaxResult remove(@RequestBody Long[] ids) {
        return toAjax(activityService.deleteActivityByIds(ids));
    }

    @PostMapping("/start/{id}")
    public AjaxResult startActivity(@PathVariable("id") Long id) {
        boolean result = activityService.startActivity(id);
        if (result) {
            return success("Activity started successfully");
        } else {
            return error("Failed to start activity");
        }
    }

    @PostMapping("/pause/{id}")
    public AjaxResult pauseActivity(@PathVariable("id") Long id) {
        boolean result = activityService.pauseActivity(id);
        if (result) {
            return success("Activity paused successfully");
        } else {
            return error("Failed to pause activity");
        }
    }

}

