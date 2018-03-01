package com.bj.playAlgorithm.BinarySearchTree.A01;

/**
 * 二分查找法
 * Created by BJ on 2018/3/1.
 */
public class BinarySearch {
    //二分查找法一般是查找有序的数组
    //在有序数组arr中，查找target
    //如果找到target，返回响应的索引index
    //如果没有找到target，返回-1

    //补充：递归实现通常思维起来更容易，不过递归在性能上回略差。

    public static int find(Comparable[] arr, Comparable target){

        //在arr[l...r]之中查找target
        int l = 0, r = arr.length-1;

        while (l <= r){
            //int mid = (l + r)/2;
            //防止极端情况下的整形溢出，使用下面的逻辑求出mid
            int mid = l + (r - l)/2;

            //正好是要查找的数
            if (arr[mid].compareTo(target) == 0){
                return mid;
            }

            if (arr[mid].compareTo(target) > 0){
                //在arr[l...mid-1]之中查找target
                r = mid - 1;
            }else {
                //在arr[mid+1...r]之中查找target
                l = mid + 1;
            }
        }

        return -1;
    }


    // 测试非递归的二分查找算法
    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }



}
