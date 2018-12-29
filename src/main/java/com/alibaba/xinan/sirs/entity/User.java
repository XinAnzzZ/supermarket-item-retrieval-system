package com.alibaba.xinan.sirs.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author XinAnzzZ
 * @date 2018/11/21 10:56
 */
@Data
public class User {

    private String id;

    @Length(min = 6, max = 16, message = "用户名长度需要在6~16个字符之间！")
    private String username;

    @Length(min = 6, max = 26, message = "密码长度需要在6~16个字符之间！")
    private String password;

    @Pattern(regexp = "^[1][3-9][0-9]{9}$", message = "手机号格式有误！")
    private String phoneNumber;

    @Pattern(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式错误！")
    private String email;

    @Null
    private Date createTime;

    @Null
    private String isDel;
}
