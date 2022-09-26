package com.decucin.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class Permission {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private String info;
}
