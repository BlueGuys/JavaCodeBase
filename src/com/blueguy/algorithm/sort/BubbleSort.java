package com.blueguy.algorithm.sort;

/**
 * Created by wangning on 2017/10/18.
 */
public class BubbleSort implements ISort {

    private int temp = 0;

    /**
     * 相邻元素换位置
     */
    @Override
    public int[] sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

}
