package com.bj.stack;

public class I<T> {
    //单项链表

    public class Node{
        private T data;//保存节点的数据
        private Node next;//指向下一个节点的引用---内存地址

        //初始化全部属性的构造器
        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    //保存该链表的头节点
    private Node header;
    //保存该链表的尾节点
    private Node tail;
    //保存该链表中已包含的节点数
    private int size;
    //创建空链表
    public I(){
        header = null;
        tail = null;
    }

    //从头添加新节点
    public void addHeader(T element){
        //创建新节点，让新节点的next指向原来的header
        //兵以新节点作为新的header
        header = new Node(element,header);
        //如果插入之前是空链表
        if(this.tail == null){
            tail = header;
        }
        size++;//因为新加了个节点size++
    }

    //从尾添加新节点
    public void addTail(T element){
        //如果插入之前是空链表
        if(this.header == null){
            header = new Node(element,null);
            tail = header;
        }else {
            //创建新节点
            Node newNode = new Node(element,null);
            //让尾节点的next指向新增的节点
            tail.next = newNode;
            //System.out.println("next:::"+tail.next);
            //System.out.println("next:::"+tail.next.data);
            //以新节点作为新的尾节点
            tail = newNode;
        }
        size++;//因为新加了个节点size++
    }

    //根据索引号找到其指定的节点
    public Node getNodeByIndex(int index){
        if(index < 0 || index > size - 1){
            System.out.println("线性表索引越界");
        }
        //从header节点开始
        Node currentNode = header;
        for(int i = 0; i < size ;i++){
            if(currentNode == null){
                break;
            }
            if(i == index){
                return currentNode;
            }
            currentNode = currentNode.next; //在没有找到的情况下，继续寻找
        }
        return null;
    }


    //在指定位置插入元素
    public void insert(T element,int index){
        if(index < 0 || index > size - 1){
            System.out.println("线性表索引越界");
            return;
        }
        if(header == null){//如果没有节点，该链表是空的
            this.addTail(element);//增加第一个节点
        }else {
            if(index == 0){//如果index为0，增加的就是头节点
                addHeader(element);
            }else {
                //获取插入点的前一个节点
                Node prev = getNodeByIndex(index-1);
                //让prev的next指向新节点，让新节点的next引用指向原来prev的下一个节点
                prev.next = new Node(element,prev.next);
                size++;
            }
        }
    }

    //删除链式线性表中指定作引处的元素
    public T delete(int index){
        if(index < 0 || index > size - 1){
            System.out.println("线性表索引越界");
        }
        Node del = null;
        //如果被删除的是header节点
        if(index == 0){
            del = header;
            header = header.next;
        }else {
            //获取删除点的前一个节点
            Node prev = getNodeByIndex(index - 1);
            //回去将要被删除的节点
            del = prev.next;
            //让被删除节点的next指向被删除节点的下一个节点
            prev.next = del.next;
            //将被删除节点的next引用赋为null
            del.next = null;
        }
        size--;
        return del.data;
    }

    //判断链式线性表是否为空表
    public boolean empty(){
        return size == 0;
    }
    //清空线性表
    public void clear(){
        //header、tail赋为null
        header = null;
        tail = null;
        size = 0;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Node current = header; current != null; current = current.next){
            sb.append(current.data.toString()+",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        I<Integer> i = new I<>();
        i.addHeader(100);
        i.addHeader(200);
        i.addHeader(300);
        i.addTail(400);
        i.addHeader(500);
        i.insert(600,2);
        i.delete(3);
        System.out.println(i);

    }


}
