package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.query.ProductQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void fun() {

    }

    @Test
    public void listAll() {
        ProductQuery query = ProductQuery.builder()
                .categoryId(1)
                .description("1")
                .minPrice(1)
                .maxPrice(9999)
                .name("点")
                .stock(20)
                .build();
        System.out.println(productMapper.listAll(query));
    }
}