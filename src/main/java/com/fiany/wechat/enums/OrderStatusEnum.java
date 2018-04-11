package com.fiany.wechat.enums;

import lombok.Getter;

/**
 * @Description : 订单枚举类
 * @Author : yifan
 * @Data : 2018/4/8 21:10
 */
@Getter
public enum  OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEWL(2,"取消"),
            ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
