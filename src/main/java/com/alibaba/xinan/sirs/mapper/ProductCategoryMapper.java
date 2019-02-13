package com.alibaba.xinan.sirs.mapper;

import com.alibaba.xinan.sirs.entity.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:06
 */
@Mapper
public interface ProductCategoryMapper {

    /**
     * 查询全部的分类
     *
     * @return category list
     */
    List<ProductCategory> listAllCategory();
}
