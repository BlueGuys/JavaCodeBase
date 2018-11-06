package com.blueguy.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式定义了字符串的模式，正则表达式可以用来搜索、编辑或处理文本。
 * Pattern 类：pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
 * Matcher 类：Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
 * PatternSyntaxException：PatternSyntaxException 是一个非强制异常类，它表示一个正则表达式模式中的语法错误。
 */
public class RegularExpressionFactory {

    /**
     * 限定符：+
     * + 号代表前面的字符必须至少出现一次（1次或多次）。例如，'zo+' 能匹配 "zo" 以及 "zoo"，但不能匹配 "z"。+ 等价于 {1,}。
     */
    public static String regex1 = "Hello+World";// HelloWorld  HellooWorld
    /**
     * 限定符：*
     * * 号代表字符可以不出现，也可以出现一次或者多次（0次、或1次、或多次）。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
     */
    public static String regex2 = "Hello*World";// HellWorld HelloWorld  HellooWorld
    /**
     * 限定符：?
     * ? 问号代表前面的字符最多只可以出现一次（0次、或1次）。例如，"do(es)?" 可以匹配 "do" 或 "does" 中的"do" 。? 等价于 {0,1}。
     */
    public static String regex3 = "Hello?World";// HellWorld HelloWorld
    /**
     * 限定符：^
     * 匹配输入字符串的开始位置。
     */
    public static String regex4 = "";// HellWorld HelloWorld

    public static void main(String[] args) {
        String input = "ab";
        System.err.println(isMatch(regex4, input) ? "OK" : "Error");
        replace();
    }

    private static boolean isMatch(String regex1, String input) {
        Pattern pattern = Pattern.compile(regex1);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static void replace() {
        String input = "Great! I like football and table tennis.";
        String regex = "foot....";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll("basketball");
        System.out.println("input:" + input);
        System.out.print("result:" + result);
    }

}
