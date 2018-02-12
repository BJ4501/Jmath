package com.bj.playAlgorithm.Sort_Basic.A05;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 插入排序
 * Created by BJ on 2018/2/12.
 */
public class InsertionSort {

    //为什么在此时，插入排序的效率要比选择排序要低呢？
    //因为三次赋值的操作，要比比较操作更耗时

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 0; i < n; i++){
            //写法1
            for(int j = i; j > 0; j--){
                //为什么不是j>=0?
                //因为每次都是与他前面的元素进行对比，j=1 时，j前面的元素是 j-1 = 0
                if (arr[j].compareTo(arr[j-1]) < 0){
                    //交换位置
                    swap(arr,j,j-1);
                }else {
                    //当发现j的位置元素已经大于j-1位置的元素了，之后就不需要进行循环
                    //即终止当前的循环即可
                    break;
                }
            }
            //写法2
            /*for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--){
                //交换位置
                swap(arr,j,j-1);
            }*/
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
