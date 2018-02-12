package com.bj.playAlgorithm.Sort_Basic.A05;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 冒泡排序
 * 它重复地走访过要排序的数列，一次比较两个元素，
 * 如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，
 * 也就是说该数列已经排序完成。
 * Created by BJ on 2018/2/12.
 */
public class BubbleSort {

    public static void sort(Comparable[] arr){

        int n = arr.length;
        boolean swapped = false;

        //这个循环与while循环的不同在于:它先执行循环中的语句,
        //a 然后再判断表达式是否为真, 如果为真则继续循环；
        //如果为假, 则终止循环。因此, do-while循环至少要执行一次循环语句。
        do{
            swapped = false;
            for (int i = 1; i < n ; i++){
                if (arr[i-1].compareTo(arr[i]) > 0){
                    swap(arr,i-1,i);
                    swapped = true;
                }
            }

            //每一次冒泡排序都将最大的元素放在了最后的位置
            //所以下一次排序，最后的元素可以不用考虑
            n--;
        }while (swapped);


    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Basic.A05.BubbleSort",arr);

        return;
    }


}
