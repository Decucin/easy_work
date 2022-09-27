package com.decucin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.WorkDetailMapper;
import com.decucin.entity.WorkDetail;
import com.decucin.service.WorkDetailService;
import org.springframework.stereotype.Service;

@Service
public class WorkDetailServiceImpl extends ServiceImpl<WorkDetailMapper, WorkDetail> implements WorkDetailService {
}
