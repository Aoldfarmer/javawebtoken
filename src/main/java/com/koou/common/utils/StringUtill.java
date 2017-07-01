package com.koou.common.utils;

/**
 * @author koou
 * @version 1.0
 * @since 2017-07-01 下午 21:33
 */
public class StringUtill {


    public static String upperFirstChar(String s) {
        char[] cs = s.toCharArray();
        if (cs[0] <= 122 && cs[0] >= 97) {
            cs[0] -= 32;
        }
        return String.valueOf(cs);
    }

    public static String lowerFirstChar(String s) {
        char[] cs = s.toCharArray();
        if (cs[0] <= 90 && cs[0] >= 65 && !s.equals("xml")) {
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }

}
