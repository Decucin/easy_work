package com.decucin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.decucin.entity.SysUser;

public interface SysUserService extends IService<SysUser> {


    SysUser findUserByUsername(String userName);

}
