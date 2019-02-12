package com.alibaba.xinan.sirs.entity.query;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:07
 */
@Data
@Builder
public class ProductQuery implements Serializable {

    private static final long serialVersionUID = 1587978970533104458L;

    /*** 商品名称 */
    private String name;

    /*** 最小价格 */
    private Integer minPrice;

    /*** 最大价格 */
    private Integer maxPrice;

    /*** 库存量 */
    private Integer stock;

    /*** 商品描述 */
    private String description;

    /*** 商品分类 */
    private Integer categoryId;
}
