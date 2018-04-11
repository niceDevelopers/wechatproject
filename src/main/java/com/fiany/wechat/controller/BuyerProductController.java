package com.fiany.wechat.controller;

import com.fiany.wechat.VO.ProductInfoVO;
import com.fiany.wechat.VO.ProductVO;
import com.fiany.wechat.VO.ResultVO;
import com.fiany.wechat.dataobject.ProductCategory;
import com.fiany.wechat.dataobject.ProductInfo;
import com.fiany.wechat.service.IProductCategoryService;
import com.fiany.wechat.service.IProductInfoService;
import com.fiany.wechat.util.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description : 买家商品
 * @Author : yifan
 * @Data : 2018/3/25 20:34
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private IProductInfoService iProductInfoService;
    @Autowired
    private IProductCategoryService iProductCategoryService;

    @GetMapping("/list")
    public ResultVO list(){
        // 1.查询所有上架商品
        List<ProductInfo> productInfoList = iProductInfoService.findUpAll();
        // 2.查询所有类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        // 精简方法将map中的type放入list中使用lambda表达式
        categoryTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = iProductCategoryService.findByCategoryTypeIn(categoryTypeList);
        // 3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if(productInfo.getCategoryType()==productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);// 等同于下面五行代码
                    productInfoVOList.add(productInfoVO);
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
