package com.decucin.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class Log {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String module;
    private String operation;
    private String method;
    private String params;
    private Long time;
}
