package com.decucin.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.decucin.entity.Permission;
import com.decucin.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    void deleteAllPermission(@Param("id") Long id);

    void insertAllPermission(@Param("id")Long id, @Param("permissions") List<Permission> permissions);

    List<Permission> selectPermission(@Param("id")Long id);
}
