package com.decucin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.LeaveMapper;
import com.decucin.dao.WorkDetailMapper;
import com.decucin.entity.Leave;
import com.decucin.entity.WorkDetail;
import com.decucin.service.LeaveService;
import com.decucin.service.WorkDetailService;
import org.springframework.stereotype.Service;

@Service
public class LeaveServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveService {
}
