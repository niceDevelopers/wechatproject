package com.fiany.wechat.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @Description : 商品（包含类目)
 * @Author : yifan
 * @Data : 2018/3/25 20:47
 */
@Data
public class ProductVO {
    @JsonProperty("name")//返回给前端的时候名称变为name
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
