package com.fiany.wechat.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description : 订单详情表
 * @Author : yifan
 * @Data : 2018/4/8 21:24
 */
@Entity
@Data
public class OrderDetail {
    /**订单详情id*/
    @Id
    private String detailId;
    /** 订单id*/
    private String orderId;
    /** 商品id*/
    private String productId;
    /** 商品名称*/
    private String productName;
    /** 商品单价 */
    private BigDecimal productPrice;
    /** 商品数量 */
    private Integer productQuantity;
    /** 商品小图*/
    private String productIcon;
}
