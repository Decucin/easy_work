package com.decucin.service;


import com.decucin.entity.SysUser;
import com.decucin.vo.Result;
import com.decucin.vo.params.LoginParam;

public interface LoginService {

    Result login(LoginParam loginParam);

    Result logout(String token);

}
