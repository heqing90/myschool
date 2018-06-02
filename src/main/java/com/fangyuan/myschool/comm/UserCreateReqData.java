package com.fangyuan.myschool.comm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReqData {
    @NonNull
    private String username;

    @NonNull
    private String password;

    @NonNull
    private String title;

    @NonNull
    private String phone;

    @NonNull
    private String address;
}
