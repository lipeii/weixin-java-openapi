package com.weixin.openapi.exception;

import com.weixin.openapi.enums.StatusCodeEnum;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 服务层异常
 *
 * @author liwenchao
 **/
@Getter
public class BusinessException extends RuntimeException {

    /**
     * 枚举码
     */
    public final AtomicReference<Integer> code = new AtomicReference<>();
    /**
     * 枚举描述
     */
    public final AtomicReference<String> msg = new AtomicReference<>();

    public BusinessException() {
        super();
    }

    public BusinessException(StatusCodeEnum statusCodeEnum) {
        super(statusCodeEnum.getName());
        this.msg.set(statusCodeEnum.getName());
        this.code.set(statusCodeEnum.getCode());
    }

    public BusinessException(StatusCodeEnum statusCodeEnum, String msg) {
        super(msg);
        this.msg.set(msg);
        this.code.set(statusCodeEnum.getCode());
    }

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.msg.set(msg);
        this.code.set(code);
    }

    public BusinessException(String msg, Integer code) {
        super(msg);
        this.msg.set(msg);
        this.code.set(code);
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg.set(msg);
        this.code.set(StatusCodeEnum.UNKNOWN_ERR.getCode());
    }

    @Override
    public String toString() {
        return this.msg.get();
    }

}
