package com.decucin.service.impl;


import com.decucin.entity.SysUser;
import com.decucin.service.LoginService;
import com.decucin.service.SysUserService;
import com.decucin.utils.JWTTokenUtils;
import com.decucin.utils.UserThreadLocal;
import com.decucin.vo.Result;
import com.decucin.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SysUserService userService;

    @Override
    public Result login(LoginParam loginParam){
        SysUser user = userService.findUserByUsername(loginParam.getUsername());
        if(user == null){
            return Result.fail("当前用户不存在");
        }
        // 此时已经确保能找到对应的user
        if(bCryptPasswordEncoder.matches(loginParam.getPassword(), user.getPassword())){
            // 创建token
            String token = JWTTokenUtils.createToken(user);
            return Result.success(token);
        }else {
            return Result.fail("用户名或密码错误！");
        }
    }

    @Override
    public Result logout(String token) {
        Long userId;
        try {
            userId = JWTTokenUtils.getUserId(token);
        }catch (Exception e){
            return Result.fail("token不合法！");
        }
        if(userId == null){
            return Result.fail("token不合法！");
        }
        UserThreadLocal.remove();
        return Result.success(null);
    }
}
