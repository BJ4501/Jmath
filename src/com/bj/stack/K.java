package com.bj.stack;

public class K {
    //约瑟夫环问题 --- 环形单链表
    //题目：41个人排成一个圆圈，由第一个人开始报数，报数到3的人就跳出圈外，然后再由下一个重新报1，
    //报数到3在跳出圈外，依次这样下去，知道剩下最后一个人时，那个人时谁？


    class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
        }
    }

    public static void main(String[] args) {
        new K().yuekill();
    }

    public void yuekill(){
        int n = 41;//定义总人数N
        int m = 3;//出圈数字M
        //初始化循环链表，头节点first和尾节点last
        Node first = new Node(0);
        first.next = first;//一个节点的时候，头就是尾，尾就是头
        Node last = first;

        //形成单链表
        for(int i=1;i<n;i++){
            Node temp = new Node(i);
            last.next = temp;
            last = last.next;//把当前游标移到下一个节点
        }

        last.next = first;//形成约瑟夫环，让其首尾相连，形成循环链表（last为尾节点）

        //执行出圈操作
        System.out.println("出圈顺序为:");
        while(last != last.next){
            //下面for循环后，last是第m个节点的前一个节点
            for(int i=1; i<m ;i++){//遍历到要删除节点的前一个数字
                last = last.next;
            }
            //出循环之后，就是要删除的节点，删除第m个节点
            System.out.print(last.next.data+" ");//出圈的数字
            last.next = last.next.next;//指向要删除的节点的下一个节点
        }
        System.out.print("幸运者是："+last.data);
    }


}
