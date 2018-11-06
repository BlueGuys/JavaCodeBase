package com.blueguy.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String str = "121221_211a";
        if(isComplexPassword2(str)){
            System.out.println("OK");
        }else{
            System.out.println("Error");
        }
    }

    public static boolean isComplexPassword2(String str) {
        String regex = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*_)[0-9A-Za-z_]{8,16}$";
        Matcher m = Pattern.compile(regex).matcher(str);
        return m.matches();
    }
}