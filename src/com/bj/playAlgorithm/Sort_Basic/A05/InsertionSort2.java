package com.bj.playAlgorithm.Sort_Basic.A05;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 插入排序 改进版
 * Created by BJ on 2018/2/12.
 */
public class InsertionSort2 {

    //对于一个近乎有序的数组来说
    //插入排序效率远远高于选择排序

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i++){

            //寻找元素arr[i] 合适的插入位置
            Comparable e = arr[i];
            int j; //保存元素e 应该插入的位置
            for ( j = i; j > 0 && arr[j-1].compareTo(e) > 0; j--){
                //将该元素后移
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }

    }

    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Basic.A05.InsertionSort",arr);

        return;
    }



}
