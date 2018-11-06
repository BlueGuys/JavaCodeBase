package com.blueguy.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangning on 2018/10/16.
 */

public class SignUtil {

    public static void main(String[] args) {
        Map<String, String> temp = new HashMap<>();
        temp.put("hello", "王宁");
        temp.put("name", "hello");
        temp.put("company", "借贷宝");
        temp.put("city", "北京");
        String ss = createSign(temp, false);
        System.out.println(ss);
    }

    public static String createSign(Map<String, String> params, boolean encode) {
        Set<String> keysSet = params.keySet();
        Object[] keys = keysSet.toArray();
        Arrays.sort(keys);
        StringBuilder temp = new StringBuilder();
        boolean first = true;
        for (Object key : keys) {
            if (first) {
                first = false;
            } else {
                temp.append("&");
            }
            temp.append(key).append("=");
            Object value = params.get(key);
            String valueString = "";
            if (null != value) {
                valueString = String.valueOf(value);
            }
            temp.append(valueString);
        }
        return MD5Utils.toMD5(temp.toString(), "UTF-8").toUpperCase();
    }

}
