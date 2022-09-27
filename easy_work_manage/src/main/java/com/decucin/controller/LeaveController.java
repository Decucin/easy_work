package com.decucin.controller;

import com.decucin.common.aop.LogAnnotation;
import com.decucin.entity.Leave;
import com.decucin.service.LeaveService;
import com.decucin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("all")
    @LogAnnotation(module = "请假管理", operation = "查询全部请假")
    public Result allLeave(){
        return Result.success(leaveService.list());
    }

    @PostMapping("save")
    @LogAnnotation(module = "请假管理", operation = "修改请假信息")
    public Result saveLeave(@RequestBody Leave leave){
        return Result.success(leaveService.save(leave));
    }

    @DeleteMapping("delete/{id}")
    @LogAnnotation(module = "请假管理", operation = "删除请假")
    public Result deleteLeave(@PathVariable("id") Long id){
        return Result.success(leaveService.removeById(id));
    }

}
