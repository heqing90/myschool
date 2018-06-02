package com.fangyuan.myschool.exception;

import com.fangyuan.myschool.comm.MyResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(MyException.class)
    public MyResponse handleException(MyException e) {
        return new MyResponse(e.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public MyResponse handleException(Exception e) {
        return new MyResponse(-1, e.getMessage(), null);
    }
}
