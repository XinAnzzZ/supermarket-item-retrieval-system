package com.alibaba.xinan.sirs.entity.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2019/2/15 10:11
 */
public class ProductAddForm implements Serializable {

    private static final long serialVersionUID = -4238539956686918253L;

    @NotEmpty
    private String name;

    @Range
    private Double price;

    @Range(max = 1000)
    private Integer stock;

    @NotEmpty
    private String description;

    @NotNull
    private Integer categoryId;

    @NotEmpty
    private String location;
}
