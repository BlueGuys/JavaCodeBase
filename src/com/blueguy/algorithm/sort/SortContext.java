package com.blueguy.algorithm.sort;

/**
 * Created by wangning on 2017/10/18.
 */
public class SortContext {

    private ISort sort;
    private int[] origin;

    public SortContext(ISort sort, int[] origin) {
        this.sort = sort;
        this.origin = origin;
    }

    public int[] sort() {
        long start = System.currentTimeMillis();
        int[] result = this.sort.sort(this.origin);
        long end = System.currentTimeMillis();
        System.out.println("排序时间:" + (end - start));
        return result;
    }
}
