package com.alibaba.xinan.sirs.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/8/20 18:35
 */
@Data
public class Role {

    private Integer id;

    private String roleName;

    private String description;

    private Date createDate;
}
