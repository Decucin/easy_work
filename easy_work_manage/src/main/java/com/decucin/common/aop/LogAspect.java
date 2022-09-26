package com.decucin.common.aop;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.ArrayUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.decucin.entity.Log;
import com.decucin.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Autowired
    private LogService logService;

    @Pointcut("@annotation(com.decucin.common.aop.LogAnnotation)")
    public void pt() {
    }

    ;

    @Around("pt()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object res = joinPoint.proceed();
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        saveLog(joinPoint, time);
        return res;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        Log log = new Log();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        LogAspect.log.info("======================log start======================");
        LogAspect.log.info("module:{}", logAnnotation.module());
        log.setModule(logAnnotation.module());
        LogAspect.log.info("operation:{}", logAnnotation.operation());
        log.setOperation(logAnnotation.operation());
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        LogAspect.log.info("request method:{}", className + "." + methodName);
        log.setMethod(className + '.' + methodName);
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        String params = ArrayUtils.isEmpty(args) ? " " : JSON.toJSONString(args[0]);
        LogAspect.log.info("params:{}", params);
        log.setParams(params);
        LogAspect.log.info("excute time:{}", time);
        log.setTime(time);
        LogAspect.log.info("======================log ended======================");
        logService.save(log);
    }
}
