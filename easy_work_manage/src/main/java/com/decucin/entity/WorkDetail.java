package com.decucin.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class WorkDetail {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private String name;
    private Date startTime;
    private Date endTime;
    private String workDetail;

}
