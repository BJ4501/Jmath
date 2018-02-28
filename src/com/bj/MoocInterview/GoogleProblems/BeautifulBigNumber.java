package com.bj.MoocInterview.GoogleProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by BJ on 2018/2/28.
 */
public class BeautifulBigNumber {

    //N -> r进制 -> 111...1(k个)
    //N = r^(k-1)+r^(k-2)+...+r+1
    //优化思路：假设N能转化成k个1组成的BeautifulNumber
    //那么这个BeautifulNumber是几进制？r=？(固定k，搜索r)
    //k取值范围2~64
    //优化使用二分查找
    //时间复杂度 logN*logN*logN
    // 64* 64* 64 << 10^8 (秒级)

    public static void main(String[] args) {
        Scanner in = new Scanner(
                new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i){
            long n = in.nextLong();
            System.out.println("Case #" + i + ": " + beautiful(n));
        }
    }

    //radix = 2 ... N-1
    //k = 2 ... 64
    //logN
    private static long beautiful(long n) {
        //题目要求输出的1越多越好
        for (int bits = 64; bits >= 2 ; bits --){
            long radix = getRadix(n,bits);
            if (radix != -1){
                return radix;
            }
        }
        //should not reach here (碰运气)
        return n - 1;
        //正常情况下需要如下处理
        //throw new IllegalStateException("should not reach here");
    }

    /**
     * logN
     * Gets radix so that n is 111...1 (bits 1 in total) in that radix.
     * @return the radix. -1 if there's no such radix.
     */
    private static long getRadix(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;
        while (minRadix < maxRadix){
            //小心数值越界
            long m = minRadix + (maxRadix - minRadix) / 2;
            //在m进制下，bits位的1值是多少
            long t = convert(m,bits);
            if (t == n){
                return m;
            }else if (t < n){
                minRadix = m + 1;
            }else {
                maxRadix = m;
            }
        }
        return -1;
    }

    /**
     * logN
     * Return the value of 111...1(bits 1 in total) in radix
     * 在m进制下，bits位的1值是多少
     */
    private static long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        //N = r^(k-1)+r^(k-2)+...+r+1
        for (int i = 0; i < bits; i++){
            //防止溢出
            if (Long.MAX_VALUE - sum < component){
                return Long.MAX_VALUE;
            }else {
                sum += component;
            }

            if (Long.MAX_VALUE / component < radix){
                component = Long.MAX_VALUE;
            }else {
                component *= radix;
            }
        }
        return sum;
    }

}
