package com.fiany.wechat.repository;

import com.fiany.wechat.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description :
 * @Author : yifan
 * @Data : 2018/4/8 21:32
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    List<OrderDetail> findByOrderId(String orderId);
}
