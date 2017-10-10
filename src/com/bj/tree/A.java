package com.bj.tree;

import java.util.ArrayList;
import java.util.List;

//用父节点表示法形成一个树
public class A {
    public static void main(String[] args) {
        //根节点
        TreeParent<String> tp = new TreeParent<>("root");
        TreeParent.Node n = tp.addNode("A",tp.root());
        tp.addNode("B",tp.root());
        TreeParent.Node n1 = tp.addNode("C",n);
        tp.addNode("D",n1);

        System.out.println("此树深度"+tp.deep());

    }




}

class TreeParent<E>{
    public static class Node<T>{
        //节点数据
        T data;
        //记录其父节点的位置
        int parent;

        public Node(T data, int parent){
            this.data = data;
            this.parent = parent;
        }
        public String toString(){
            return "父节点表示法[data="+data+",parent="+parent+"]";
        }
    }
    //树节点的数量
    private int treeSize = 100;
    //使用一个Node[]数组来记录该树里的所有节点
    private Node<E>[] nodes;
    //记录节点数
    private int nodeNums;
    //实例化构造器
    public TreeParent(E data){
        Node newNode = new Node(data ,-1);//根节点
        nodes = new Node[treeSize];
        nodes[0] = newNode;
        nodeNums++;
    }

    //返回根节点
    public Node root(){
        return nodes[0];
    }

    //返回包含指定值的节点的索引
    public int pos(Node node){
        for(int i = 0; i < treeSize; i++){
            //找到指定节点
            if(nodes[i] == node){//地址一样
                return i;
            }
        }
        return -1;
    }

    //为指定父节点添加子节点
    public Node addNode(E data, Node parent){
        Node newNode = null;
        for(int i = 0;i < treeSize;i++){
            //找到数组中第一个为null的元素，该元素保存新节点
            if(nodes[i] == null){
                //创建新节点，并用指定的数组元素保存它
                newNode = new Node(data,pos(parent));
                nodes[i] = newNode;
                nodeNums++;
                break;
            }
        }
        // throw new RuntimeException("该树已满，无法添加新节点");
        return newNode;
    }

    //返回该树的深度：树中节点的最大层次值 从1开始
    //求该树的深度，实际上是每个节点到根节点的个数
    public int deep(){
        //用于记录节点的最大深度
        int max = 0;
        for(int i = 0;i < treeSize && nodes[i] != null;i++){
            //初始化本节点的深度
            int def = 1;
            //m记录当前节点的父节点位置
            int m = nodes[i].parent;//父节点的索引
            //如果其父节点存在
            while (m != -1 /*&& nodes[m] != null*/){//只要M!=-1,说明没有到根节点
                //向上继续搜索父节点
                m = nodes[m].parent;
                def++;
            }
            if(def > max){//找到最大值就赋给max
                max = def;
            }
        }
        //返回最大深度
        return max;
    }

    //返回指定节点(非叶子节点)的所有子节点
    /*public List<Node<E>> getChildren(Node parent){
        List<Node<E>> list = new ArrayList<>();


    }*/





}
