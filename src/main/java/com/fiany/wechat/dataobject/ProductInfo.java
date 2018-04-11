package com.fiany.wechat.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Description : 商品
 * @Author : yifan
 * @Data : 2018/3/23 6:44
 */
@Entity
@Data
public class ProductInfo {
    @Id
    /** 商品id */
    private String productId;
    /** 商品名称 */
    private String productName;
    /** 商品价格 */
    private BigDecimal productPrice;
    /** 商品库存 */
    private Integer productStock;
    /** 商品描述 */
    private String productDescription;
    /** 商品状态0正常1下架 */
    private Integer productStatus;
    /** 商品类目编号 */
    private Integer categoryType;
    /** 商品小图*/
    private String productIcon;

}
