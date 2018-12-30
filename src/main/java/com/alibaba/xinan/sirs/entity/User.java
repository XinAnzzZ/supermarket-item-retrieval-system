package com.alibaba.xinan.sirs.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/11/21 10:56
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    private String phoneNumber;

    private String email;

    private Date createTime;

    private String isDel;
}
