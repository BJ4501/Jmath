package com.bj.MoocInterview.recursion;

import com.bj.MoocInterview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 反转链表
 * Created by BJ on 2018/2/26.
 */
public class ReverseLinkedList {

    /**
     * Reverse a linked list.
     * 1-2-3-null revert to null-1-2-3
     * @param head head the linked list to reverse
     * @return head of the reversed linked list
     */
    public Node reverseList(Node head){
        //size == 0
        if (head == null){
            return null;
        }
        //size == 1
        if (head.getNext() == null){
            return head;
        }
        Node newHead = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return newHead;
    }



    public static void main(String[] args) {

        CreateLinkedList c = new CreateLinkedList();
        ReverseLinkedList rll = new ReverseLinkedList();

        Node.printLinkedList(rll.reverseList(c.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(rll.reverseList(c.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(rll.reverseList(c.createLinkedList(Arrays.asList(1,2,3,4,5))));

    }
}
