package com.bj.playAlgorithm.Sort_Basic.A04;

import com.bj.playAlgorithm.Sort_Basic.A03.SortTestHelper;

/**
 * 选择排序法SelectionSort
 * Created by BJ on 2018/1/31.
 */
public class SelectionSort {

    //排序方法逻辑部分
    public static <T extends  Comparable<T>> void sort(T[] arr){
        int length = arr.length;

        for (int i = 0; i < length; i++){
            //寻找[1,n)区间内，最小数值的索引
            int minindex = i;
            for(int j = i + 1; j < length; j++){
                //使用compareTo方法比较两个Comparable对象的大小
                //标准比较结果
                //return (x < y) ? -1 : ((x == y) ? 0 : 1);
                // < 0 意思是 arr[j] < arr[minindex]
                // > 0 意思是 arr[j] > arr[minindex]
                if ( arr[j].compareTo(arr[minindex]) < 0 ){
                    minindex = j;
                }
            }
            //手动实现交换方法
            swap( arr , i , minindex);
        }
    }

    //交换i位置和minindex位置的数值
    private static void swap(Object[] arr, int i, int minindex) {
        Object t = arr[i];
        arr[i] = arr[minindex];
        arr[minindex] = t;
    }

    public static void main(String[] args) {

        //测试排序算法的辅助函数
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);

        com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Basic.A04.SelectionSort",arr);

    }

}
