package com.alibaba.xinan.sirs.util;

/**
 * @author XinAnzzZ
 * @date 2019/1/2 10:17
 */
public class StringUtils {

    /**
     * 判断 string 为空
     *
     * @param strings the string array
     * @return true if one of the string array is empty
     */
    public static boolean isEmpty(String... strings) {
        for (String string : strings) {
            if (string == null || string.isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
