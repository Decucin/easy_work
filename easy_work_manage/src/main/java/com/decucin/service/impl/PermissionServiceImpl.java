package com.decucin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.PermissionMapper;
import com.decucin.dao.RoleMapper;
import com.decucin.entity.Permission;
import com.decucin.entity.Role;
import com.decucin.service.PermissionService;
import com.decucin.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
