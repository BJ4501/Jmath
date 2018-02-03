package com.bj.playAlgorithm.Sort_Basic.A03;

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

}
