package com.alibaba.xinan.sirs.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Moore
 * @since 2019-05-25
 */
@Data
public class Account {

    @NotNull
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String sex;

    @NotNull
    private Integer age;

    @NotNull
    private Integer salary;

    @NotNull
    private String location;

    @NotNull
    private String status;
}
