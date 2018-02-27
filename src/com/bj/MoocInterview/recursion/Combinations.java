package com.bj.MoocInterview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 列出所有组合
 * 题目：类似数组入下(1,2,3,4) 从中选出n个元素
 * 例：2个
 * 答案：1,2;1,3;1,4;2,3;2,4;3,4 共6钟组合
 * Created by BJ on 2018/2/26.
 */
public class Combinations {

    /**
     * 从Data中选取n个元素
     */
    public void combinations(List<Integer> selected, List<Integer> data, int n){
        //递归基准值
        //如何选择元素
        //如何输出
        //如果需要选取0个元素，有一种情况，empty list
        if (n == 0){
            //output all selected elements + empty list
            for (Integer integer : selected) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if (data.isEmpty()){
            return;
        }

        //如果需要选取-1的元素，不存在
        /*if (n < 0){
            return;
        }*/

        //这种递归感觉应该类似分支的感觉，如下：
        /*
         * null -> 1 -> 1,2
         *           -> 1,null -> 1,3
         *                     -> 1,null -> 1,4
         *      -> 2 -> 2,3
         *           -> 2,null -> 2,4
         *      -> 3 -> 3,4
         *
         *      通过分支执行完毕有6种可能
         */

        //select element 0
        selected.add(data.get(0));
        combinations(selected,data.subList(1,data.size()),n-1);

        //un-select element 0
        //如果不选择这个元素，就从list中删除
        selected.remove(selected.size() - 1);
        combinations(selected,data.subList(1,data.size()),n);

    }

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4), 2);
        System.out.println("-----");
        comb.combinations(new ArrayList<>(), new ArrayList<>(), 2);
        System.out.println("-----");
        comb.combinations(new ArrayList<>(), new ArrayList<>(), 0);
        System.out.println("-----");
        comb.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4), 1);
        System.out.println("-----");
        comb.combinations(new ArrayList<>(), Arrays.asList(1,2,3,4,5,6,7,8,9), 4);
    }
}
