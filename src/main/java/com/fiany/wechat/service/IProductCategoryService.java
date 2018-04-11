package com.fiany.wechat.service;

import com.fiany.wechat.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 */
public interface IProductCategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
