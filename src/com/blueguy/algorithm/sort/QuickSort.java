package com.blueguy.algorithm.sort;

/**
 * http://flyingcat2013.blog.51cto.com/7061638/1281614
 */
public class QuickSort implements ISort {
    @Override
    public int[] sort(int[] arr) {
        sortCore(arr, 0, arr.length - 1);
        return arr;
    }

    private void sortCore(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            sortCore(arr, low, pivot - 1);                   //递归排序左子数组
            sortCore(arr, pivot + 1, high);                  //递归排序右子数组
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
