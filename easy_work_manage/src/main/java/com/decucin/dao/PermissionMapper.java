package com.decucin.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.decucin.entity.Permission;
import com.decucin.entity.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
