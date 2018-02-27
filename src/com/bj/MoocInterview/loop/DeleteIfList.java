package com.bj.MoocInterview.loop;

import com.bj.MoocInterview.common.Node;
import com.bj.MoocInterview.recursion.CreateLinkedList;

import java.util.Arrays;

/**
 * 链表删除节点
 * Created by BJ on 2018/2/27.
 */
public class DeleteIfList {

    //如果链表头部就是我需要删除的节点，那么有两种处理方式
    //1.使用特殊情况处理
    //2.增加虚拟头节点

    /**
     * 链表删除节点功能--标准答案(使用特殊情况处理)
     * @param head 原头节点
     * @param delValue 需要删除的值
     * @return 新头节点
     */
    public Node deleteIfList(Node head, int delValue){
        // 这种判断条件下，如果Node为2,2,2,2,3,4 delValue == 2的情况
        // 由于头节点只移动了一次，所以删除不完全
        /*if (head.getValue() == delValue){
            head = head.getNext();
        }*/
        // 解决方法：使用while
        while (head != null && head.getValue() == delValue){
            head = head.getNext();
        }
        if (head == null){
            return null;
        }
        //从头部到prev之间的数据已经处理完毕
        Node prev = head;

        while (prev.getNext() != null){
            if (prev.getNext().getValue() == delValue){
                //delete it
                //将指针跳过即可(C++中还需要删除节点)
                prev.setNext(prev.getNext().getNext());
            }else {
                prev = prev.getNext();
            }
        }
        return head;
    }


    //链表删除节点功能--BJ--存在问题
    public Node deleteIfList2(Node head, int delValue){

        Node newHead = head;
        //searchPoint
        //尝试每次都查找下一个Point是否为需要删除的Point
        //如果该Point需要删除，取出其中的next
        Node curHead = head;//搜索遍历使用的Point

        //如果head本身就是delPoint
        if (head.getValue() == delValue){
            newHead = head.getNext();
            curHead = newHead;
        }

        while(curHead.getNext() != null){

            //如果是需要删除的节点
            if (curHead.getNext().getValue() == delValue){
                curHead.setNext(curHead.getNext().getNext());
            }

            curHead = curHead.getNext();

        }

        return newHead;
    }

    public static void main(String[] args) {

        CreateLinkedList c = new CreateLinkedList();
        DeleteIfList rll = new DeleteIfList();
/*
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(Arrays.asList(1))));*/
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(Arrays.asList(1,2,3,4,5)),2));
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(Arrays.asList(1,2,3,2,5)),2));
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(Arrays.asList(2,2,3,2,5)),2));
        Node.printLinkedList(rll.deleteIfList(c.createLinkedList(Arrays.asList(2,2,2,2,2)),2));
    }
}
