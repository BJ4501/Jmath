package com.bj.others;

import java.util.Scanner;

public class buffonNeddle {

    /*
    * 投点法 得到π的近似值
    * 方形中的圆形，圆面积πr² 正方形面积（2r）² 进行比值 π/4
    * 所以说 圆面积比上正方形面积 结果是四分之一的π
    * 将这个比值乘4 得出π值
    *
    * */

    public static void main(String[] args) {
        long insideCircle = 0;
        long outsideCircle = 0;
        long i;
        double x,y;
        Scanner testTime = new Scanner(System.in);
        long testLimit = testTime.nextLong();
        for(i = 0; i<testLimit ; i +=1){
            x = Math.random();
            y = Math.random();//random 范围0-1
            if((0.5-x)*(0.5-x)+(0.5-y)*(0.5-y)<0.25){
                insideCircle += 1;
            }
            else {
                outsideCircle += 1;
            }
            //System.out.println((0.0+i)/testLimit);
        }
        System.out.println(4*insideCircle);
        System.out.println(0.0+insideCircle+outsideCircle);
        System.out.println(4*insideCircle/(0.0+insideCircle+outsideCircle));
    }
}
