package com.bj.MoocInterview.recursion;

import com.bj.MoocInterview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 链表创建
 * Created by BJ on 2018/2/26.
 */
public class CreateLinkedList {

    /**
     * CreateTreeProblem linked list
     * @param data Data to create the list
     * @return head of the linked list
     */
    public Node createLinkedList(List<Integer> data){
        if (data.isEmpty()){
            return null;
        }
        //第一个Node
        Node firstNode = new Node(data.get(0));
        //递归：subList去掉0之后的所有元素,如果没有元素subList会返回空串
        Node headOfSublist = createLinkedList(data.subList(1,data.size()));
        firstNode.setNext(headOfSublist);
        return firstNode;
    }

    public static void main(String[] args) {
        CreateLinkedList c = new CreateLinkedList();

        Node.printLinkedList(c.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(c.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(c.createLinkedList(Arrays.asList(1,2,3,4,5)));

    }

}
