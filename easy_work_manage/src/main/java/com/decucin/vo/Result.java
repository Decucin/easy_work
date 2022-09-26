package com.decucin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：decucin
 * @date ：Created in 2021/10/21 21:35
 * @description：这个类用来保存同意显示的结果
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public static Result success(Object data){
        return new Result(200, "成功", data);
    }

    public static Result fail(int code, String msg){
        return new Result(code, msg, null);
    }
    public static Result fail( String msg){
        return new Result(500, msg, null);
    }
}
