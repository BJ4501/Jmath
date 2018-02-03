package com.bj.playAlgorithm.Sort_Basic.A04;

import java.lang.reflect.Method;

/**
 * 生成测试用的随机数组工具类
 * Created by BJ on 2018/2/3.
 */
public class SortTestHelper {

    private SortTestHelper() {}

    //生成有n个元素的随机数组，每个元素的随机范围为[rangeL,rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){

        //JAVA assert 关键字
        //assert [boolean 表达式]
        //如果[boolean表达式]为true，则程序继续执行。
        //如果为false，则程序抛出AssertionError，并终止执行。
        assert rangeL <= rangeR;

        Integer[] arr = new Integer[n];

        //Math.random()生成0-1之间的小数
        //首先生成 0 到 rangeR - rangeL 之间的数 之后再加 rangeL
        //则生成随机数的范围就变成了 rangeL 到 rangeR 之间了
        for (int i = 0; i < n; i++){
            arr[i] = new Integer((int)(Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arr;
    }

    //打印arr数组的所有内容
    public static void printArray(Object arr[]){

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    //判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr){
        for (int i = 0; i < arr.length - 1; i++)
            //如果检查中发现有数据不符合排序规则，未正确排序，就返回false
            if (arr[i].compareTo(arr[i+1]) > 0)
                return false;
        return true;
    }

    //测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName, Comparable[] arr){

        // 通过Java的反射机制，通过排序的类名，运行排序函数
        // * 依然是，使用反射机制并不是这个课程的重点,
        // 大家也完全可以使用自己的方式书写代码,
        // 最终只要能够测试出自己书写的算法的效率即可
        // * 推荐大家阅读我在问答区向大家分享的一个学习心得:
        // 【学习心得分享】请大家抓大放小，不要纠结于C++语言的语法细节
        // * 链接: http://coding.imooc.com/learn/questiondetail/4100.html

        try{
            //通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            //通过排序函数的Class对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            //排序参数只有一个：可比较数组arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            //调用排序函数
            sortMethod.invoke(null,params);
            long endTime = System.currentTimeMillis();

            assert isSorted(arr);

            System.out.println(sortClass.getSimpleName()+ " : "
                    + (endTime - startTime) + "ms");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
