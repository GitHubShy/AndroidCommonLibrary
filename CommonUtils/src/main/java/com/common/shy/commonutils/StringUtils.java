package com.common.shy.commonutils;

public class StringUtils {

    /**
     * Determine whether the string is empty
     *
     * @param val
     * @return
     */
    public static boolean isEmpty(String val) {
        if (val == null || "".equals(val)) return true;
        return false;
    }

    /** Return the index of the Nth times occurrence of the matString in the string
     * @param string the whole string
     * @param matString the string that needs to be matched
     * @param nTh the times
     * @return the index;If didn't find index ,return 0
     */
    public static int getCharacterPosition(String string, String matString, int nTh) {
        int count = 0;
        for (int i = 1; i <= nTh; i++) {
            count = string.indexOf(matString, count + 1);
            if (count == -1) {
                return 0;
            }
        }
        return count;
    }
}
