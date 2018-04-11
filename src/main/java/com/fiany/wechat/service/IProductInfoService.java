package com.fiany.wechat.service;

import com.fiany.wechat.dataobject.ProductInfo;
import com.fiany.wechat.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Description : 商品service
 * @Author : yifan
 * @Data : 2018/3/23 7:00
 */

public interface IProductInfoService {
    ProductInfo findOne(String productId);

    /**查找所有在架商品*/
    List<ProductInfo> findUpAll();
    /** 查找所有商品，分页*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    // TODO 加减库存
    void increaseStock(List<CartDTO> cartDTOList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
