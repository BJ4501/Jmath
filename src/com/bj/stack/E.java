package com.bj.stack;


import java.util.Arrays;

//使用数组制作队列
public class E {
    //默认长度
    private int DEFAULT_SIZE = 10;
    //保存数组的长度
    private int capacity;
    //定义一个数组用于保存顺序队列的元素
    private int[] elementData;
    //保存顺序队列中元素的当前个数
    private int front = 0;//出
    private int rear = 0;//进
    //以默认数组长度创建空顺序队列
    public E(){
        capacity = DEFAULT_SIZE;
        elementData = new int[capacity];//开个对象数组
    }
    //获取顺序队列的大小
    public int length(){
        return rear - front;
    }
    //判断顺序队列是否为空队列
    public boolean empty(){
        return rear == front;
    }
    //返回队列顶元素，但不删除队列顶元素
    public int element(){
        if(empty()){
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return elementData[front];
    }
    public void add(int newdata){//入队列 rare++
        if(rear>this.capacity-1){//0
            System.out.println("队列已经满了");
        }else {
            elementData[rear++] = newdata;
        }
    }
    public int remove(){//出队列 front++
        if(this.empty()){//0
            System.out.println("队列为空");
            return -1;
        }else {
            int d = elementData[front++];
            return d;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData);
    }

    public static void main(String[] args) {
        E e = new E();
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(4);

        System.out.println(e.remove());
        System.out.println(e);



    }



}
