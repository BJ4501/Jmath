package com.bj.playAlgorithm.Sort_Basic.A02;

/**
 * 选择排序法SelectionSort
 * Created by BJ on 2018/1/31.
 */
public class SelectionSort {

    //排序方法逻辑部分
    public static void sort(Comparable[] arr){
        int length = arr.length;

        for (int i = 0; i < length; i++){
            //寻找[1,n)区间内，最小数值的索引
            int minindex = i;
            for(int j = i + 1; j < length; j++){
                //使用compareTo方法比较两个Comparable对象的大小
                //标准比较结果
                //return (x < y) ? -1 : ((x == y) ? 0 : 1);
                // < 0 意思是 arr[j] < arr[minindex]
                // > 0 意思是 arr[j] > arr[minindex]
                if ( arr[j].compareTo(arr[minindex]) < 0 ){
                    minindex = j;
                }
            }
            //手动实现交换方法
            swap( arr , i , minindex);
        }
    }

    //交换i位置和minindex位置的数值
    private static void swap(Object[] arr, int i, int minindex) {
        Object t = arr[i];
        arr[i] = arr[minindex];
        arr[minindex] = t;
    }

    public static void main(String[] args) {

        // 测试Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.sort(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.sort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort.sort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectionSort.sort(d);
        for( int i = 0 ; i < d.length ; i ++ )
            System.out.println(d[i]);
    }

}
