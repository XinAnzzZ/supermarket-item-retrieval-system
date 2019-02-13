package com.alibaba.xinan.sirs.entity.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:42
 */
@Data
public class ProductQueryForm implements Serializable {

    private static final long serialVersionUID = -835362047634252248L;

    /*** 商品名称 */
    private String name;

    /*** 最小价格 */
    private Integer minPrice;

    /*** 最大价格 */
    private Integer maxPrice;

    /*** 商品描述 */
    private String description;

    /*** 商品分类 */
    private Integer categoryId;

    private Integer pageSize;

    private Integer pageNum;
}
