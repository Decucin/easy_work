package com.decucin.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.decucin.entity.SysUser;
import com.decucin.service.LoginService;
import com.decucin.service.SysUserService;
import com.decucin.utils.JWTTokenUtils;
import com.decucin.utils.UserThreadLocal;
import com.decucin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginIntercepter implements HandlerInterceptor {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断当前方法是否需要拦截
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        String token = request.getHeader("Authorization");
        if(StringUtils.isBlank(token)){
            Result fail = Result.fail(403, "token不合法");
            response.getWriter().print(JSON.toJSON(fail));
            return false;
        }
        // 登录逻辑

        Long userId = null;
        try {
            userId = JWTTokenUtils.getUserId(token);
        }catch (Exception e){
            Result result = Result.fail(403, "token不合法");
            response.getWriter().print(JSON.toJSON(result));
            return false;
        }
        SysUser user = sysUserService.getById(userId);
        if(user == null){
            Result result = Result.fail("用户不存在");
            response.getWriter().print(JSON.toJSON(result));
            return false;
        }
        // 用户信息保存在ThreadLocal中将
        UserThreadLocal.put(user);
        // 放行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserThreadLocal.remove();
    }
}
