package com.alibaba.xinan.sirs.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2019/2/12 11:05
 */
@Data
public class ProductCategory implements Serializable {

    private static final long serialVersionUID = 4102218698228649846L;

    private Integer id;

    private String name;

    private Date createTime;

    private Date updateTime;

    private Integer isDel;
}
