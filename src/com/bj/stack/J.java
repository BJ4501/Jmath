package com.bj.stack;

public class J<T> {
    //双向链表
    private class Node{
        private T data; //保存节点的数据
        private Node prev;//指向上个节点的引用
        private Node next;//指向下个节点的引用

        public Node(T data,Node prev,Node next){
            this.data = data;
            this.prev = prev;
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
    public J(){
        header = null;
        tail = null;
    }
    //获取链式线性表中索引为index处的元素
    public T get(int index){
        return getNodeByIndex(index).data;
    }

    //根据索引index获取指定位置的节点
    public Node getNodeByIndex(int index){
        if(index < 0|| index > size - 1){
            System.out.println("线性表索引越界");
        }
        //优化写法
        //根据双向链表查找的最佳途径，比如查找时可以判断索引是否大于size的一般，如果是的话，就从另一头开始迭代
        if(index <= size/2){
            //从header节点开始，正着方向header-tail
            Node current = header;
            for(int i = 0; i <= size/2 && current !=null; i++,current = current.next){
                if(i == index){
                    return current;
                }
            }
        }else {//左侧没找到，从另一侧查找
            //从tail节点开始搜索，倒着方向tail-header
            Node current = tail;
            for(int i = size - 1; i > size/2 && current != null; i++,current = current.prev){
                if(i == index){
                    return current;
                }
            }
        }
        return null;
    }

    //查找链式线性表中指定元素的索引
    public int findElement(T element){
        //从头节点到尾节点开始搜索
        Node current = header;
        for(int i = 0;i< size && current != null;i++, current = current.next){
            if(current.data.equals(element)){
                return i;
            }
        }
        return -1;//没有找到
    }
    //向线性链式表的指定位置插入一个元素
    public void insert(T element,int index){
        if(index < 0 || index > size){
            System.out.println("线性表索引越界");
        }
        //如果还是空链表
        if(header == null){
            addTail(element);
        }else {
            //当index为0时，也就是在链表头插入
            if(index == 0){
                addHeader(element);
            }else {//中间插入
                //获取插入点的前一个节点
                Node prev = getNodeByIndex(index - 1);
                //获取插入点的节点
                Node next = prev.next;
                //让新节点的next引用指向next节点，prev阴影指向prev节点
                Node newNode = new Node(element,prev,next);
                //让prev的next指向新节点
                prev.next = newNode;
                //让prev的下一个节点的prev指向新节点
                next.prev = newNode;
                size++;
            }
        }
    }


    //为链表头添加新节点
    public void addHeader(T element){
        //创建新节点，让新节点的next指向原来的header
        //兵以新节点作为新的header
        header = new Node(element,null,header);
        //如果插入之前是空链表
        if(tail == null){
            tail = header;
        }
        size++;
    }

    //为链表尾添加新节点
    public void addTail(T element){
        //如果该链表是空链表
        if(header == null){
            header = new Node(element,null,null);
            tail = header;
        }else {
            //创建新节点，新节点的pre指向原tail节点
            Node newNode = new Node(element,tail,null);
            //让尾节点next指向新增的节点
            tail.next = newNode;
            //以新节点作为新的尾节点
            tail = newNode;
        }
        size++;//链表长度增加1
    }

    public T delete(int index){
        if(index < 0 || index > size - 1){
            System.out.println("线性表索引越界");
        }
        Node del = null;
        //如果被删除的是header节点
        if(index == 0){
            del = header;
            header = header.next;
            //释放新的header节点的prev引用
            header.prev = null;//不是循环链表
        }else {
            //获取删除点的前一个节点
            Node prev = getNodeByIndex(index - 1);
            //获取将要被删除的节点
            del = prev.next;
            //让被删除节点的next执行被删除节点的下一个节点
            prev.next = del.next;
            //让被删除节点的下一个节点的prev指向prev节点
            if(del.next != null){
                del.next.prev = prev;
            }
            //将被删除节点的prev，next引用赋为null
            del.prev = null;
            del.next = null;
        }
        size--;
        return del.data;
    }

    //删除链式现行表的最后一个元素
    public T remove(){
        return delete(size-1);
    }

    //判断链式线性表是否为空表
    public boolean empty(){
        return size == 0;
    }

    //清空线性表
    public void clear(){
        //将底层数组所有元素赋为null
        header = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(J.Node current = header; current != null; current = current.next){
            sb.append(current.data.toString()+",");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        J<Integer> i = new J<>();
        i.addHeader(100);
        i.addHeader(200);
        i.addTail(600);
        i.addHeader(300);
        i.addTail(400);
        i.addTail(500);

        System.out.println(i);

    }







}
