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
    ERROR_PARAM(405, "错误的参数！"),

    ERROR_VERIFICATION_CODE(400, "验证码错误！");

    private Integer code;

    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
