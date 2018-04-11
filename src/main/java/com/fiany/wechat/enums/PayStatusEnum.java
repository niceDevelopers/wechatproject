package com.fiany.wechat.enums;

import lombok.Getter;

/**
 * @Description : 支付枚举
 * @Author : yifan
 * @Data : 2018/4/8 21:18
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
