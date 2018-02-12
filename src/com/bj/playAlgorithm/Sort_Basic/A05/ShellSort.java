package com.bj.playAlgorithm.Sort_Basic.A05;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 希尔排序
 * 详解地址
 * https://www.cnblogs.com/chengxiao/p/6104371.html
 * Created by BJ on 2018/2/12.
 */
public class ShellSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;

        // 计算 increment sequence: 1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while (h < n/3)
            h = 3*h + 1;

        while (h >= 1) {

            // h-sort the array
            for (int i = h; i < n; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for ( ; j >= h && e.compareTo(arr[j-h]) < 0 ; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Basic.A05.ShellSort",arr);

        return;
    }

}
