package com.alibaba.xinan.sirs.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/7/24 14:00
 */
@Getter
public enum ResponseEnum {

    /*** 未知错误 */
    UNKNOWN_ERROR(500, "未知错误！"),

    /*** 缺少必须参数 */
    MISS_PARAM(400, "缺少必须参数！"),

    /*** 缺少token */
    MISS_TOKEN(401, "缺少Token！"),

    /*** 无权限 */
    NO_PERMISSION(402, "权限不足！"),

    /*** token中缺少必须参数 */
    ERROR_TOKEN(403, "错误的token！"),

    /*** 错误的参数 */
    ERROR_PARAM(406, "错误的参数！"),

    /*** 账号不存在 */
    UNKNOWN_ACCOUNT(410, "账号不存在！"),

    /*** 密码错误 */
    INCORRECT_CREDENTIAL(411, "密码错误！"),

    /*** 没有访问权限 */
    UNAUTHORIZED(412, "没有访问权限！"),

    /*** 登陆失败 */
    LOGIN_FAILURE(413, "登陆失败！"),

    ERROR_VERIFICATION_CODE(414, "验证码错误！");

    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
