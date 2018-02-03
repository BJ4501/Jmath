package com.bj.playAlgorithm.Sort_Basic.A01;

/**
 * 选择排序法SelectionSort
 * Created by BJ on 2018/1/31.
 */
public class SelectionSort {

    //排序方法逻辑部分
    public static void sort(int[] arr){
        int length = arr.length;

        for (int i = 0; i < length; i++){
            //寻找[1,n)区间内，最小数值的索引
            int minindex = i;
            for(int j = i + 1; j < length; j++){
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            //手动实现交换方法
            swap( arr , i , minindex);
        }
    }

    //交换i位置和minindex位置的数值
    private static void swap(int[] arr, int i, int minindex) {
        int t = arr[i];
        arr[i] = arr[minindex];
        arr[minindex] = t;
    }

    public static void main(String[] args) {

        int[] arr = {10,9,8,7,6,5,4,3,2,1};

        SelectionSort.sort(arr);

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

}
