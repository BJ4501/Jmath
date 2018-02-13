package com.bj.playAlgorithm.Sort_Advance.A03;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 快速排序 O(n*log n)
 * Created by BJ on 2018/2/12.
 */
public class RandomQuickSort {

    //FIXME 快速排序在近似有序的数组情况下，会退化为O(n^2)的时间复杂度
    //因为，近乎有序的数组，在快速排序的情况下，左侧都基本不会有元素
    //例： 1234567897 这样的数组需要排序
    //重点：在近乎有序的数组的排序，归并排序效率极高，至少比快速排序要快很多

    // 优化方法：在这种情况下，不是每次都指定最左边元素为V，
    // 而是在arr[l...r]范围内，随机寻找一个数，将其放置到最左边，
    // 此时，这个概率的数学期望接近logn，完成了这种情况下的算法优化，
    // 此时即使是近乎有序的数组，效率也有了很大提升，不过此时的效率仍有退化至O(n^2)的可能性，
    // 不过这个概率已经及其小了(退化为On^2的情况为：每次随机选的数字都是最左边的，不过这个概率太小了)

    // 进一步，优化方法：对于小规模数组，使用插入排序

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        //最左侧的v 作为左右分隔的元素
        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v

        for (int i = l+1; i <= r; i++){
            if (arr[i].compareTo(v) < 0){
                j++;
                swap(arr,j,i);
            }
        }

        swap(arr,l,j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        //如果只有一个元素，不排序
        if (l >= r)
            return;

        //p则是最后分隔用元素v 的位置
        int p = partition(arr, l, r);

        sort(arr,l,p-1);
        sort(arr,p+1,r);
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

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Advance.A04.RandomQuickSort", arr);

        return;
    }

}
