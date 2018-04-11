package com.fiany.wechat.service;

import com.fiany.wechat.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Description : 订单service
 * @Author : yifan
 * @Data : 2018/4/8 21:52
 */
public interface IOrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);
    /** 查询单个订单*/
    OrderDTO findOne(String orderId);
    /** 查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /** 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /** 完结订单*/
    OrderDTO finished(OrderDTO orderDTO);
    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);
}
