package com.common.shy.commonutils;

public class StringUtils {
    /**
     * 判断字符串是否为空
     *
     * @param val
     * @return
     */
    public static boolean isEmpty(String val) {
        if (val == null || "".equals(val)) return true;
        return false;
    }
}
