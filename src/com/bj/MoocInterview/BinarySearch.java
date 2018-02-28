package com.bj.MoocInterview;

import java.util.Collection;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 二分查找
 * Created by BJ on 2018/2/27.
 */
public class BinarySearch {

    /**
     * Searches element k in a sorted array.
     * @param arr a sorted array
     * @param k the element to search
     * @return index in arr where k is. -1 if not found.
     */
    public int binarySearch(int[] arr, int k){
        int a = 0;
        int b = arr.length;
        //Loop invariant: [a,b) is a valid range. (a <= b)
        //k may only be (只可能) within range [a,b)
        while (a < b){
            //if (a == b) return -1;

            //BUG：当数组很大的情况下a+b会溢出
            //int m = (a + b) / 2;
            //修复：
            int m = a + (b - a) / 2;

            //特殊情况： a == b : m = a and m = b
            //b == a + 1 : m = a
            //b == a + 2 : m = a + 1
            if (k < arr[m]) { // a ... (m - 1)
                //b = m 优势：[a,b) + [b,c) = [a,c)
                //b - a = len([a,b))
                //[a,a) ==> empty range
                b = m;
            }else if (k > arr[m]){
                a = m + 1;
            }else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(
                binarySearch.binarySearch(new int[]{1,2,10,15,100},15));
        System.out.println(
                binarySearch.binarySearch(new int[]{1,2,10,15,100},-2));
        System.out.println(
                binarySearch.binarySearch(new int[]{1,2,10,15,100},101));
        System.out.println(
                binarySearch.binarySearch(new int[]{1,2,10,15,100},13));
        System.out.println("=====");
        System.out.println(
                binarySearch.binarySearch(new int[]{},13));
        System.out.println(
                binarySearch.binarySearch(new int[]{12},13));
        System.out.println(
                binarySearch.binarySearch(new int[]{13},13));


    }
}
