package com.bj.stack;


public class G<T> {
    //单项链式队列
    //定义一个内部类Node，Node实例代表链队列的节点
    private class Node{
        //保存节点的数据
        private T data;
        //指向下个节点的引用
        private Node next;
        //初始化全部属性的构造器
        public Node (T data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    //保存改链队列的头节点
    private Node front;
    //保存该链队列的尾节点
    private Node rear;
    //保存该链队列中已包含的节点数
    private int size;

    //将新元素加入队列，在rear进行增加
    public void add(T element){
        //如果该链队列是空链队列
        if(front == null){
            front = new Node(element,null);
            //只有一个节点，front，rear都指向该节点
            rear = front;
        }else {
            //创建新节点
            Node newNode = new Node(element,null);
            //让尾节点的next指向新增的节点
            rear.next = newNode;
            //以新节点作为新的尾节点
            rear = newNode;
        }
        size++;
    }

    public T remove(){
        Node oldFront = front;//老节点
        T data = oldFront.data;//取出老节点的数据

        front = front.next;//将front指向下一个节点，因为老节点已经弹出
        oldFront = null;//将老节点置空

        return data;
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();
        for (Node current = front; current != rear.next; current = current.next){
            stringBuffer.append(current.data.toString()+",");
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        G<String> queue = new G<String>();
        //添加两个元素
        queue.add("bbbb");
        queue.add("cccc");
        System.out.println(queue);
        //删除一个元素后
        queue.remove();
        System.out.println("删除一个元素后的队列：" + queue);
        //再次添加一个元素
        queue.add("dddd");
        System.out.println("再次添加元素后的队列：" + queue);
        //删除一个元素后，队列可以再多加一个元素
        queue.remove();
        //再次加入一个元素
        queue.add("eeee");
        System.out.println("先删除，再添加元素的队列："+queue);
    }






}
