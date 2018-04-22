package com.fiany.wechat.service.impl;

import com.fiany.wechat.dataobject.OrderDetail;
import com.fiany.wechat.dto.OrderDTO;
import com.fiany.wechat.enums.OrderStatusEnum;
import com.fiany.wechat.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private  OrderServiceImpl orderService;

    private final String BUYER_OPENID = "123123";

    private final String BUYER_ORDERID = "1523369308866529519";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("fiany大本营");
        orderDTO.setBuyerName("fiany");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("123123");
        List<OrderDetail> detailList = new ArrayList<OrderDetail>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1");
        o1.setProductQuantity(2);
        detailList.add(o1);
        orderDTO.setOrderDetailList(detailList);
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        String orderId = "1523369308866529519";
        OrderDTO orderDTO = orderService.findOne(orderId);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,10);
        Page<OrderDTO> list = orderService.findList(BUYER_OPENID, new PageRequest(0,10));
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(BUYER_ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEWL.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void finished() {
        OrderDTO orderDTO = orderService.findOne(BUYER_ORDERID);
        OrderDTO result = orderService.finished(orderDTO);
        Assert.assertEquals(result.getOrderStatus(),OrderStatusEnum.FINISHED.getCode());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(BUYER_ORDERID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(result.getPayStatus(), PayStatusEnum.SUCCESS.getCode());
    }
}