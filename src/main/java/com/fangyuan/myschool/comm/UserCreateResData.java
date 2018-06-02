package com.fangyuan.myschool.comm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserCreateResData {

    @NonNull
    private Long userId;
}
