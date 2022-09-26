package com.decucin.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.decucin.entity.Role;
import com.decucin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    void deleteAllRoles(@Param("id") Long id);

    void insertAllRoles(@Param("id") Long id, @Param("roles") List<Role> roles);

    List<Role> selectRoles(@Param("id") Long id);
}
