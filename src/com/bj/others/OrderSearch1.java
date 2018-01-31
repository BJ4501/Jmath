package com.bj.others;

public class OrderSearch1 {
    /**
     * 优化顺序查找，避免每次比较后都要判断查找位置是否越界for()，在总数据较多的时候，效率提高很大
     *
     *
     */

    public static int orderSearch(int searchKey, int [] a, int n){
        int i;
        i = n;//int n为数组长度,循环从数组尾部开始
        a[0] = searchKey;
        while (a[i] != searchKey){
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        int [] test = new int [] {1,2,29,3,95,3,5,6,7,9,12};
        int index = OrderSearch1.orderSearch(95,test,test.length-1);
        System.out.println("查找到的位置："+ index);

    }
}
