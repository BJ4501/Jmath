package com.bj.playAlgorithm.Sort_Basic.A02;

/**
 * Created by BJ on 2018/2/3.
 */
public class Student implements Comparable<Student>{

    //Comparable java的比较器
    //compareTo 类似于C++的重载运算符，可以对一个Object进行比较

    private String name;

    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //定义Student的compareTo函数
    //如果分数相等，则按照名字的字母顺序排序
    //如果分数不等，则分数高的在前面
    @Override
    public int compareTo(Student that) {
        if (this.score == that.score)
            //这个compareTo是String内部的比较,比较字典序
            return this.name.compareTo(that.name);
        //下面这段可以简写为
        //Integer.compare(that.score, this.score);
        if (this.score < that.score)
            return 1;
        else if (this.score > that.score)
            return -1;
        else  //this.score == that.score
            return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
