package com.decucin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.RoleMapper;
import com.decucin.entity.Role;
import com.decucin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean save(Role entity) {
        super.save(entity);
        roleMapper.deleteAllPermission(entity.getId());
        roleMapper.insertAllPermission(entity.getId(), entity.getPermissions());
        return true;
    }

    @Override
    public boolean removeById(Serializable id) {
        super.removeById(id);
        roleMapper.deleteAllPermission((Long) id);
        return true;
    }

    @Override
    public List<Role> list() {
        List<Role> roles = super.list();
        for (Role role : roles){
            role.setPermissions(roleMapper.selectPermission(role.getId()));
        }
        return roles;
    }

}
