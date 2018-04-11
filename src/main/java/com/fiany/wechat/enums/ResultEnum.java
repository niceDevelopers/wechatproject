package com.fiany.wechat.enums;

import lombok.Getter;

/**
 * @Description : 返回枚举
 * @Author : yifan
 * @Data : 2018/4/10 20:06
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不正确")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
