package com.fangyuan.myschool.comm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyResponse {
    private Integer code;
    private String desc;
    private Object data;
}
