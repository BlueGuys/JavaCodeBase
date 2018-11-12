package com.blueguy.algorithm.search;

public class Test {

    public static void main(String[] args) {
        String t = "在世间，本就是各人下雪，各人有各人的隐晦与皎洁";
        String p = "各人的隐晦与皎洁";
        System.out.println(searchA(t, p));
    }


    /**
     * 朴素匹配算法
     *
     * @param t 原字符串
     * @param p 模版字符串
     * @return p在s中第一次出现的位置
     */
    private static int searchA(String t, String p) {
        char[] T = t.toCharArray();
        char[] P = p.toCharArray();
        int m = T.length;
        int n = P.length;
        if (m < n) {
            return -1;
        }
        int i = 0;//主串的位置
        int j = 0;//模式串的位置
        while (i < m && j < n) {
            if (T[i] == P[j]) { // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else { // 一旦不匹配，i后退
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == n) {
            return i - j;
        } else {
            return -1;
        }
    }


}
