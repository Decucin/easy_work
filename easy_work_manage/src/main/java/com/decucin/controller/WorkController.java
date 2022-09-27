package com.decucin.controller;

import com.decucin.common.aop.LogAnnotation;
import com.decucin.entity.WorkDetail;
import com.decucin.service.WorkDetailService;
import com.decucin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("work")
public class WorkController {

    @Autowired
    private WorkDetailService workDetailService;

    @GetMapping("all")
    @LogAnnotation(module = "工作周报模块", operation = "获取全部工作周报")
    public Result getAllWork(){
        return Result.success(workDetailService.list());
    }

    @PostMapping("save")
    @LogAnnotation(module = "工作周报模块", operation = "保存工作周报")
    public Result saveWork(@RequestBody WorkDetail workDetail){
        return Result.success(workDetailService.save(workDetail));
    }

    @DeleteMapping("delete/{id}")
    @LogAnnotation(module = "工作周报模块", operation = "删除工作周报")
    public Result deleteWork(@PathVariable("id") Long id){
        return Result.success(workDetailService.removeById(id));
    }

}
