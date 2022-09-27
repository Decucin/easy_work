package com.decucin.controller;

import com.decucin.common.aop.LogAnnotation;
import com.decucin.entity.Permission;
import com.decucin.entity.Role;
import com.decucin.entity.SysUser;
import com.decucin.service.PermissionService;
import com.decucin.service.RoleService;
import com.decucin.service.SysUserService;
import com.decucin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("users/all")
    @LogAnnotation(module = "用户模块", operation = "查询全部用户")
    public Result getAllUser(){
        return Result.success(sysUserService.list());
    }

    @PostMapping("users/save")
    @LogAnnotation(module = "用户模块", operation = "保存用户")
    public Result saveUser(@RequestBody SysUser sysUser){
        return Result.success(sysUserService.save(sysUser));
    }

    @DeleteMapping("users/delete/{id}")
    @LogAnnotation(module = "用户模块", operation = "删除用户")
    public Result deleteUser(@PathVariable("id") Long id){
        return Result.success(sysUserService.removeById(id));
    }

    @GetMapping("roles/all")
    @LogAnnotation(module = "角色模块", operation = "查询全部角色")
    public Result allRole(){
        return Result.success(roleService.list());
    }

    @PostMapping("roles/save")
    @LogAnnotation(module = "角色模块", operation = "保存角色")
    public Result saveRole(@RequestBody Role role){
        return Result.success(roleService.save(role));
    }

    @DeleteMapping("roles/delete/{id}")
    @LogAnnotation(module = "角色模块", operation = "删除角色")
    public Result deleteRole(@PathVariable("id") Long id){
        return Result.success(roleService.removeById(id));
    }

    @GetMapping("permissions/all")
    @LogAnnotation(module = "权限模块", operation = "查询全部权限")
    public Result allPermission(){
        return Result.success(permissionService.list());
    }

    @PostMapping("permissions/save")
    @LogAnnotation(module = "权限模块", operation = "保存权限")
    public Result savePermission(@RequestBody Permission permission){
        return Result.success(permissionService.save(permission));
    }

    @DeleteMapping("permissions/delete/{id}")
    @LogAnnotation(module = "权限模块", operation = "删除权限")
    public Result deletePermission(@PathVariable("id") Long id){
        return Result.success(permissionService.removeById(id));
    }
}
