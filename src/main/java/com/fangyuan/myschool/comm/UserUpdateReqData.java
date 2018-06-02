package com.fangyuan.myschool.comm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserUpdateReqData {

    @NonNull
    private Long userId;

    private String username;

    private String password;

    private String title;

    private String phone;

    private String address;
}

