package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.Product;
import com.alibaba.xinan.sirs.entity.form.ProductAddForm;
import com.alibaba.xinan.sirs.entity.query.ProductQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:06
 */
@Mapper
public interface ProductMapper {

    /**
     * 查找符合条件的商品
     *
     * @param query 条件查询封装对象
     * @return 商品列表
     */
    List<Product> listAll(@Param("query") ProductQuery query);

    /**
     * 插入
     *
     * @param productAddForm the product
     */
    void insert(@Param("form") ProductAddForm productAddForm);

    /**
     * delete by id
     *
     * @param productId the product id
     */
    @Update("UPDATE product SET is_del = 1 WHERE id in (#{productId})")
    void deleteById(@Param("productId") String productId);
}
