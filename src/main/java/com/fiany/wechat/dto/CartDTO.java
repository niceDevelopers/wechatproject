package com.fiany.wechat.dto;

import lombok.Getter;

/**
 * @Description : 购物车
 * @Author : yifan
 * @Data : 2018/4/10 21:06
 */
@Getter
public class CartDTO {
    /** 商品id*/
    private String productId;
    /** 商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
