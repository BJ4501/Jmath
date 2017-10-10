package com.bj.stack;

import java.util.Stack;

//找到一个栈中的最小元素
public class C {
    //声明两个栈
    private Stack<Integer> min = null;
    private Stack<Integer> data = null;

    public C(){
        min = new Stack<>();
        data = new Stack<>();
    }
    //自己写压栈，需要比较
    public void push(int newData){
        //弹出最小栈的栈顶元素和newData比较，如果比栈顶的小，压入最小栈
        if(newData<this.getMin()){
            min.push(newData);

        }
        data.push(newData);
    }
    //弹出最终结果
    public int pop(){
        return min.peek();

    }
    //弹出最小栈的栈顶
    public int getMin(){
        if(min.isEmpty()){
            //System.out.println("此最小栈为空");
            return Integer.MAX_VALUE;//返回int最大值
        }else {
            return min.peek();
        }


    }

    public static void main(String[] args) {
        C c = new C();
        c.push(3);
        c.push(1);
        c.push(2);
        c.push(0);
        c.push(9);
        c.push(10);
        System.out.println(c.pop());
    }


}
