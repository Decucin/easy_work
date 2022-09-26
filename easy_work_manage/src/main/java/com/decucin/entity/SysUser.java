package com.decucin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;


@Data
public class SysUser {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String username;
    private String email;
    private String phone;
    private String password;
    private Boolean sex;
    @TableField(exist = false)
    private List<Role> roles;

}
