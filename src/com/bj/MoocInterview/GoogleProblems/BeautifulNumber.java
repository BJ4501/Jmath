package com.bj.MoocInterview.GoogleProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by BJ on 2018/2/28.
 */
public class BeautifulNumber {
    /*  寻找BeautifulNumber
     *  1,11,111... -> beautiful
     *  3 -> 2进制 -> 11 beautiful (1*3*3 + 1*3 + 1 = 13)
     *  13 -> 3进制 -> 111 beautiful ()
     *
     *  小数据范围 3 <= N <= 1000
     *  大数据范围 3 <= N <= 10^18
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i){
            int n = in.nextInt();
            System.out.println("Case #" + i + ": " + beautiful(n));
        }
    }

    /** O(NlogN)  max N = 10^18
     * Search the beautiful number
     * @param n number in radix 10
     * @return only '1' number in whichever radix
     */
    private static int beautiful(int n) {
        //前提：任何一个数都能被转换成BeautifulNumber，(n-1)进制
        //例：1000 = 11 在 999 进制下
        // 123 = 11 在 122 进制下
        //最简单方法就是从二进制开始试
        for (int radix = 2; radix < n ; radix ++){
            if (isBeautiful(n,radix)){
                return radix;
            }
        }
        //should not reach here (碰运气)
        return n - 1;
        //正常情况下需要如下处理
        //throw new IllegalStateException("should not reach here");
    }

    /**
     * isBeautiful？
     * @param n number
     * @param radix radix
     * @return radix
     */
    private static boolean isBeautiful(int n, int radix) {
        while (n > 0){
            //位数
            if (n % radix != 1){
                return false;
            }
            n /= radix;
        }
        return true;
    }

}
