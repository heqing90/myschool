package com.fangyuan.myschool.exception;


import lombok.Getter;
import lombok.Setter;

public class MyException extends RuntimeException {

    @Getter
    @Setter
    protected Integer code;

    public MyException(String message, Integer code, Throwable e) {
        super(message, e);
        this.code = code;
    }

    public MyException(String message, Integer code) {
        this(message, code, null);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable e) {
        super(e);
    }

    public MyException() {
    }
}
