package com.common.shy.commonutils;

import java.util.List;


public class ListUtils {

    /**
     * Determine whether the string is empty
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(List list) {
        if (list == null || list.isEmpty()) return true;
        return false;
    }
}
