package com.decucin.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.SysUserMapper;
import com.decucin.entity.SysUser;
import com.decucin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    @Override
    public boolean save(SysUser entity) {
        super.save(entity);
        sysUserMapper.deleteAllRoles(entity.getId());
        sysUserMapper.insertAllRoles(entity.getId(), entity.getRoles());
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        super.removeById(id);
        sysUserMapper.deleteAllRoles((Long) id);
        return true;
    }

    @Override
    public List<SysUser> list() {
        List<SysUser> users = super.list();
        for (SysUser sysUser : users){
            sysUser.setRoles(sysUserMapper.selectRoles(sysUser.getId()));
        }
        return users;
    }


    @Override
    public SysUser findUserByUsername(String userName) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, userName);
        return sysUserMapper.selectOne(wrapper);
    }
}
