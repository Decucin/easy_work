package com.decucin.utils;


import com.decucin.entity.SysUser;

public class UserThreadLocal {
    
    private UserThreadLocal(){

    }

    public static final ThreadLocal<SysUser>  LOCAL = new ThreadLocal<>();

    public static void put(SysUser user){
        LOCAL.set(user);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
