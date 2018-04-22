package com.fiany.wechat.controller;

import com.fiany.wechat.VO.ResultVO;
import com.fiany.wechat.converter.OrderForm2OrderDTOConverter;
import com.fiany.wechat.dto.OrderDTO;
import com.fiany.wechat.enums.ResultEnum;
import com.fiany.wechat.exception.SellException;
import com.fiany.wechat.form.OrderForm;
import com.fiany.wechat.service.impl.OrderServiceImpl;
import com.fiany.wechat.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description : 买家订单控制层
 * @Author : yifan
 * @Data : 2018/4/22 13:13
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImpl orderService;
    // 创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    // 订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value="openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page ,
                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest pageRequest = new PageRequest(page, pageSize);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    // 订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)){
            log.error("【订单详情】openid或orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        // TODO 防越权
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO ==  null || !orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【订单详情】不存在该订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return ResultVOUtil.success(orderDTO);
    }

    // 取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId){
        if(StringUtils.isEmpty(openid) || StringUtils.isEmpty(orderId)){
            log.error("【订单详情】openid或orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        // TODO 防越权
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(StringUtils.isEmpty(openid) || !orderDTO.getBuyerOpenid().equals(openid)){
            log.error("【订单详情】不存在该订单");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        orderService.cancel(orderDTO);
        return ResultVOUtil.success();
    }
}
