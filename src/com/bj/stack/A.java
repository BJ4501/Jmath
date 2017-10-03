package com.bj.stack;

import java.util.Stack;

//java自带的stack
public class A {

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(100);
        s.push(200);
        s.push(300);

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());


    }


}
