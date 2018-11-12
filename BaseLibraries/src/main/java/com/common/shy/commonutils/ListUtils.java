package com.common.shy.commonutils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import jxl.Workbook;


public class ListUtils {

    /**
     * Determine whether the string is empty
     */
    public static boolean isEmpty(List list) {
        if (list == null || list.isEmpty()) return true;
        return false;
    }

    /**
     * Delete the duplicate element,keep the order
     */
    public static void removeDuplicateWithOrder(List list) {
        if (list == null) {
            return;
        }
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
    }
}
