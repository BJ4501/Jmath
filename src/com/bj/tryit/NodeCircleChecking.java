package com.bj.tryit;

import com.bj.MoocInterview.common.Node;
import com.bj.MoocInterview.recursion.CreateLinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * 链表环的判断
 * Created by neko on 2018/3/7.
 */
public class NodeCircleChecking {

    Node node = new Node(1);

    public Node makeNodeCircle(){

        Node firstNode = createLinkedList(Arrays.asList(1,2,3,4,5));
        Node nextNode = firstNode;

        while(true){
            if (firstNode == null){
                return null;
            }
            if (nextNode.getNext() == null){
                //构成一个环
                nextNode.setNext(firstNode);
                return firstNode;
            }
            nextNode = nextNode.getNext();
        }

    }

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

    public void checkNodeCircle(Node firstNode){

        Node p1 = firstNode;
        Node p2 = firstNode;

        while (true){

            if (p1.getNext() == null || p2.getNext() == null){
                System.out.println("Is not a Node Circle");
                break;
            }

            p1 = p1.getNext();
            p2 = p2.getNext().getNext();

            //NCheck
            if (p1 == p2){
                System.out.println("Is a Node Circle");
                break;
            }
        }

    }

    public static void main(String[] args) {

        CreateLinkedList cl = new CreateLinkedList();

        NodeCircleChecking checking = new NodeCircleChecking();
        Node firstNode = checking.makeNodeCircle();

        Node next = firstNode;

        //print Node
        /*while (true){
            if (next == null){
                break;
            }
            System.out.println(next.getValue());
            next = next.getNext();
        }*/
        checking.checkNodeCircle(firstNode);

        checking.checkNodeCircle(cl.createLinkedList(Arrays.asList(1,2,3,4,5)));

        System.out.println("OK");

    }


}
