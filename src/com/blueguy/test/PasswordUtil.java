package com.blueguy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangning on 2018/10/16.
 */

public class PasswordUtil {

    /**
     * 复杂密码校验
     */
    public static boolean isComplexPassword(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
//        System.out.println(isContainLetter(str)?"包含字母":"不包含字母");
//        System.out.println(isContainNumber(str)?"包含数字":"不包含数字");
//        System.out.println(isContainSymbol(str)?"包含符号":"不包含符号");
        return isContainLetter(str) && isContainNumber(str) && isContainSymbol(str);
    }

    private static boolean isContainLetter(String str) {
        String regex = ".*[a-zA-Z]+.*";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.matches();
    }

    private static boolean isContainNumber(String str) {
        String regex = "[0-9]";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.find();
    }

    private static boolean isContainSymbol(String str) {
        String regex = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.find();
    }

    public static boolean isComplexPassword2(String str) {
        String regex = "/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z_]{6,18}$/";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.find();
    }

}
