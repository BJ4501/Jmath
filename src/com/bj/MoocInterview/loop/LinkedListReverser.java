package com.bj.MoocInterview.loop;

import com.bj.MoocInterview.common.Node;
import com.bj.MoocInterview.recursion.CreateLinkedList;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by BJ on 2018/2/27.
 */
public class LinkedListReverser {

    public Node reverseLinkedList(Node head){
        Node newHead = null;
        Node curHead = head;
        //Loop invariant:(循环不变式)
        //newHead 指向已经反转的链表
        //curHead 指向还没有反转的链表
        while(curHead != null){
            //还没有反转的链表的next下一个元素
            Node next = curHead.getNext();
            //反转指向
            curHead.setNext(newHead);
            //两个Head同时向右移
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        CreateLinkedList c = new CreateLinkedList();
        LinkedListReverser rll = new LinkedListReverser();

        Node.printLinkedList(rll.reverseLinkedList(c.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(rll.reverseLinkedList(c.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(rll.reverseLinkedList(c.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}
