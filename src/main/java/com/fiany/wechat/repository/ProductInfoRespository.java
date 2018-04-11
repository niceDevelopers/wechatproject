package com.fiany.wechat.repository;

import com.fiany.wechat.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description : 商品dao
 * @Author : yifan
 * @Data : 2018/3/23 6:52
 */
public interface ProductInfoRespository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
