package com.fiany.wechat.service.impl;

import com.fiany.wechat.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(2);
        Assert.assertEquals(new Integer(2),productCategory.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = productCategoryService.findAll();
        Assert.assertNotEquals(new Integer(1), new Integer(productCategoryList.size()));
    }

    @Test
    public void findByCategoryTypeIn() {
        List productCategoryList = Arrays.asList(2,3,4);
        List<ProductCategory> productCategorylist = productCategoryService.findByCategoryTypeIn(productCategoryList);
        Assert.assertNotEquals(new Integer(1), new Integer(productCategoryList.size()));
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(4);
        productCategory.setCategoryName("小王");
        ProductCategory result = productCategoryService.save(productCategory);
        Assert.assertEquals("小王", result.getCategoryName());
    }
}