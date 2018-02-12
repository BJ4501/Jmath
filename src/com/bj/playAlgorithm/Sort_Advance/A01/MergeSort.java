package com.bj.playAlgorithm.Sort_Advance.A01;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序 O(n*log n)
 * Created by BJ on 2018/2/12.
 */
public class MergeSort {

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r){

        //辅助归并使用的临时空间，这个也就是为什么归并排序需要额外On的空间的原因
        //将归并需要的数复制到这个空间中
        Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

        //偏移量l：因为原始数组是从0开始的，aux复制的数组是从l开始的，也就是说存在l的偏移量

        //将箭头指向两个子数开头的位置
        //i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l , j = mid + 1;
        //K
        for (int k = l; k <= r; k++ ){
            if (i > mid){ //说明此时j索引中的数组中的元素还没有完全归并
                //如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j++;
            }else if (j > r){ //说明此时i索引中的数组中的元素还没有完全归并
                //如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i++;
            }else if (aux[i-l].compareTo(aux[j-l]) < 0){
                //左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l];
                i++;
            }else {
                //左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    //递归使用归并排序，对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        //代表递归到底，只有一个元素的情况下，是不需要再次拆分
        if (l >= r)
            return;

        int mid = (l+r)/2;
        //递归排序
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        //之后进行合并merge操作，核心操作就在merge中
        merge(arr,l,mid,r);
    }


    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n-1);
    }

    // 测试MergeSort
    public static void main(String[] args) {

        // Merge Sort是我们学习的第一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        // 注意：不要轻易尝试使用SelectionSort, InsertionSort或者BubbleSort处理100万级的数据
        // 否则，你就见识了O(n^2)的算法和O(nlogn)算法的本质差异：）
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Advance.A01.MergeSort", arr);

        return;
    }

}
