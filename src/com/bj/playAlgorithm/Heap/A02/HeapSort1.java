package com.bj.playAlgorithm.Heap.A02;

import com.bj.playAlgorithm.Heap.A01.MaxHeap;
import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 使用堆排序
 * Created by BJ on 2018/2/13.
 */
public class HeapSort1 {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

        for (int i = 0; i < n; i++)
            maxHeap.insert(arr[i]);

        //从小到大排序，从该数组的最后一个元素开始填写
        for (int i = n-1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    // 测试 HeapSort1
    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Heap.A02.HeapSort1", arr);

        return;
    }

}
