package com.fiany.wechat.enums;

import lombok.Getter;

/**
 * @Description : 商品状态枚举类
 * @Author : yifan
 * @Data : 2018/3/23 7:16
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
