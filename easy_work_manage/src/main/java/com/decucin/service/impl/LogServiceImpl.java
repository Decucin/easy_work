package com.decucin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.decucin.dao.LogMapper;
import com.decucin.entity.Log;
import com.decucin.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {
}
