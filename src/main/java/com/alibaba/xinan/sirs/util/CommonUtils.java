package com.alibaba.xinan.sirs.util;

import java.util.UUID;

/**
 * @author XinAnzzZ
 * @date 2018/12/29 16:24
 */
public class CommonUtils {

    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
