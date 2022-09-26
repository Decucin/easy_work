package com.decucin.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.decucin.entity.Log;
import com.decucin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log> {
}
