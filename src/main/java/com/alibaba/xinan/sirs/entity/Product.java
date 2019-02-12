package com.alibaba.xinan.sirs.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:02
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 2495234477386458072L;

    private String id;

    private String name;

    private Double price;

    private Integer stock;

    private String description;

    private Integer status;

    private ProductCategory productCategory;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;
}
