package com.koou.common.utils;

/**
 *
 * @author yunqiangdi
 * @version 1.0
 * @since 2017-06-29 7:10 PM
 */
public class StringUtil {

    /**
     * 首字母大写
     * @param name name (97-122)
     * @return string
     */
    public static String upperFirstChar(String name) {
        char[] cs=name.toCharArray();
        if (cs[0] <= 122 && cs[0] >= 97 && !name.equals("xml")) {
            cs[0] -= 32;
        }
        return String.valueOf(cs);
    }

    /**
     * 首字母小写
     * @param name name
     * @return string
     */
    public static String lowerFirstChar(String name) {
        char[] cs=name.toCharArray();
        if (cs[0] <= 90 && cs[0] >= 65) {
            cs[0] += 32;
        }
        return String.valueOf(cs);
    }
}
