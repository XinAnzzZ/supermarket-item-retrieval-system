package com.alibaba.xinan.sirs.consts;

/**
 * 正则常量
 *
 * @author XinAnzzZ
 * @date 2019/1/2 10:24
 */
public class RegexConst {

    /**
     * 邮箱正则表达式
     */
    public static final String EMAIL_REGEX = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 手机号正则表达式
     */
    public static final String PHONE_REGEX = "^[1][3-9][0-9]{9}$";
}
