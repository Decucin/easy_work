package com.decucin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class Role {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private String info;
    @TableField(exist = false)
    private List<Permission> permissions;
}
