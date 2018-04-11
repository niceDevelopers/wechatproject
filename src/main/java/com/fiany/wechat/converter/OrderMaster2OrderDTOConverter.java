package com.fiany.wechat.converter;

import com.fiany.wechat.dataobject.OrderMaster;
import com.fiany.wechat.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description : 类型转换
 * @Author : yifan
 * @Data : 2018/4/11 21:32
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }
    public static List<OrderDTO> converter(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
            converter(e)
        ).collect(Collectors.toList());
    }
}
