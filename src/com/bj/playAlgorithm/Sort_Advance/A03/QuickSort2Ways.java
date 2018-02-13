package com.bj.playAlgorithm.Sort_Advance.A03;

import com.bj.playAlgorithm.Sort_Basic.A04.SortTestHelper;

/**
 * 快速排序 O(n*log n)
 * Created by BJ on 2018/2/12.
 */
public class QuickSort2Ways {

    //FIXME 当数组中具有非常多的重复数的情况下，
    // 分隔出的数组两端又变的不平衡了，在这种情况下，效率又退化为了On^2


    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r){

        swap(arr,l,(int)(Math.random()*(r-l+1))+l);

        //最左侧的v 作为左右分隔的元素
        Comparable v = arr[l];

        // arr[l+1...j] <= v ; arr[j+1...i) => v
        int i = l+1, j = r;

        //当i大于j时会跳出循环
        while (true){
            //arr[i].compareTo(v) < 0,
            while (i <= r && arr[i].compareTo(v) < 0)
                i ++;

            while (j >= l+1 && arr[j].compareTo(v) > 0)
                j --;

            //当i大于j时会跳出循环
            if (i > j)
                break;

            //最后当找到满足交换条件的i和j的时候，进行交换
            swap(arr,i,j);

            //交换后，这两个指针下的值就不需要再次进行比较了，直接到下一位
            i++;
            j--;
        }

        //最后将处于边界条件中的v，交换回j 的位置，此时两边的数组满足上面的条件
        swap(arr,i,j);

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

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.bj.playAlgorithm.Sort_Advance.A03.QuickSort2Ways", arr);

        return;
    }

}
