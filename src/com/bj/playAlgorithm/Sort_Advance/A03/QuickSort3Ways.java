package com.bj.playAlgorithm.Sort_Advance.A03;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 快速排序 O(n*log n)
 * Created by BJ on 2018/2/12.
 */
public class QuickSort3Ways {

    //三路的快速排序
    //v --->   <v ; =V ; >v

    private QuickSort3Ways(){}

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static void sort(Comparable[] arr, int l, int r){

        //如果只有一个元素，不排序
        if (l >= r)
            return;

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        //partition
        int lt = l; // arr[l+1...lt] < v
        int gt = r; // arr[gt...r] > v
        int i = l+1; // arr[lt+1...i) == v

        //如果i与gt接触说明该次替换已经完成
        while ( i < gt){
            if (arr[i].compareTo(v) < 0){
                swap(arr, lt+1, i);
                lt ++;
                i ++;
            }else if (arr[i].compareTo(v) > 0){
                swap(arr,gt-1,i);
                gt--;
            }else { // arr[i] == v
                i++;
            }
        }
        swap(arr,l,lt);

        //递归
        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }


    //使用递归方式,测试暴露的方法
    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) {

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Advance.A03.QuickSort3Ways", arr);

        return;
    }

}
