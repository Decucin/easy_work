package com.decucin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.decucin.entity.Leave;
import com.decucin.entity.WorkDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {
}
