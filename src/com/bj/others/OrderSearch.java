package com.bj.others;

public class OrderSearch {

    /**顺序查找平均时间复杂度O(n)
     *searchKey 要查找的值
     * array 数组（从这个数组中查找）
     * return 查找结果（数组的下标位置）
     *
     * 效率低
    * */
    public static int OrderSearch(int searchKey, int[] array){
        for(int i = 0;i < array.length;i++){
            if(array[i] == searchKey){
                return i;
            }
        }
        return -1;
    }
}
