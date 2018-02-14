package com.bj.playAlgorithm.Heap.A02;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 使用堆排序
 * Created by BJ on 2018/2/13.
 */
public class HeapSort {

    //原地堆排序优点，不需要开辟一个额外的空间
    public static void sort(Comparable[] arr){

        int n = arr.length;
        //heapify操作生成最大堆
        //此时是从0开始索引的，最后一个元素的索引是n-1
        //作是要从(最后一个索引)-1/2的位置开始，所以是n-1-1
        for (int i = (n - 1 - 1)/2; i >= 0; i--){
            shiftDown(arr,n,i);
        }

        //进行交换操作之后每次都shiftDown
        for (int i = n - 1; i > 0; i --){
            //相当于每次都把最大的那个数移动到数组末端实现了排序
            swap(arr,i,0);
            //移动到末端的数就不需要再进行shiftDown操作了
            shiftDown(arr,i,0);
        }
    }


    // 原始的shiftDown过程
    private static void shiftDown(Comparable[] arr, int n, int k) {

        //左child不越界
        while( 2*k+1 < n){
            int j = 2*k+1;
            if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0){
                j = j + 1;
            }

            if (arr[k].compareTo(arr[j]) >= 0){
                break;
            }

            swap(arr , k , j);
            k = j;
        }

    }

    // 交换堆中索引为i和j的两个元素
    private static void swap(Object[] arr, int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Heap.A02.HeapSort", arr);

        return;
    }

}
