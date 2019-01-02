package com.alibaba.xinan.sirs.entity.form;

import com.alibaba.xinan.sirs.consts.RegexConst;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author XinAnzzZ
 * @date 2018/12/29 22:30
 */
@Data
public class UserRegisterForm implements Serializable {

    private static final long serialVersionUID = -3530217724875959654L;

    @Length(min = 6, max = 16, message = "用户名长度需要在6~16个字符之间！")
    private String username;

    @Length(min = 6, max = 26, message = "密码长度需要在6~16个字符之间！")
    private String password;

    private String passwordRepeat;

    @Pattern(regexp = RegexConst.PHONE_REGEX, message = "手机号格式有误！")
    private String phoneNumber;

    @Pattern(regexp = RegexConst.EMAIL_REGEX, message = "邮箱格式错误！")
    private String email;
}
