package com.bj.stack;

public class H<T> {
    //链式双向队列
    public class Link<T> {//链节点
        T data;//数据域
        Link<T> next;//后继指针，结点   链域
        Link<T> previous;// 前驱指针，结点  链域
        Link(T data){
            this.data = data;
        }
        void displayLink(){
            System.out.println("数据是："+ data.toString());
        }
    }

    private Link<T> head;//首部结点
    private Link<T> rear;//尾部结点

    public boolean isEmpty(){
        return head == null;
    }

    public void insertFirst(T data){//从头部进入双向队列
        Link<T> newLink = new Link(data);
        if(this.isEmpty()){//第一个节点
            rear = newLink;
        }else {//不是第一个节点的时候
            head.previous = newLink;//旧头结点的上节点等于新节点

        }
        newLink.next = head;//新节点的下一节点是旧的头结点
        head = newLink;//赋值后，头结点的下结点是旧头节点，上节点null
    }

    public void insertLast(T data){//在尾部增加
        Link<T> newLink = new Link<T>(data);
        if(isEmpty()){
            head = newLink;
        }else {
            rear.next = newLink;
        }
        newLink.previous = rear;
        rear = newLink;//赋值后，尾节点的上节点是旧的尾节点，下结点null
    }

    //删除 链头 并且返回删除的数据
    public T deleteHead(){
        if (isEmpty()){
            return null;
        }
        Link<T> temp = head;
        head = head.next;//变更首节点，为下一节点
        if(head != null){
            head.previous = null;
        }else {
            rear = null;
        }
        return temp.data;
    }

    //删除 链尾 并且返回删除的数据
    public T deleteRear(){
        if (isEmpty()){
            return null;
        }
        Link<T> temp = rear;
        rear = rear.previous;//变更首节点，为上一节点
        if(rear != null){
            rear.next = null;
        }else {
            head = null;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        H<Integer> list = new H<>();
        list.insertLast(1);
        list.insertFirst(2);
        list.deleteRear();
        list.insertLast(3);
        list.insertFirst(4);
        list.insertLast(5);
        list.deleteHead();
        list.displayFromHead();
    }

    public void displayFromHead(){
        Link<T> current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }



}
