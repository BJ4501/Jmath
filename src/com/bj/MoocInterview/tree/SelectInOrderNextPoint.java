package com.bj.MoocInterview.tree;

/**
 * 寻找中序遍历时的下一个结点
 * 可以实现快速查找功能(左子树比根小，右子树比根大)
 * Created by BJ on 2018/2/28.
 */
public class SelectInOrderNextPoint {
    /*
     *    P
     *    N
     *  L   R
     *
     *  L:无关
     *  R ! = null 返回右子树的第一个节点
     *  否则 P != null
     *      N是P的左子树 -> 返回P
     *      N是P的右子树 -> 一直往父亲结点走，直到是某个结点左子树
     */

    public TreeNode next(TreeNode node){
        if (node == null){
            return null;
        }
        if (node.getRight() != null){
            //返回右子树的第一个结点
            return first(node.getRight());
        }else {
            //Right null 向上走
            //如果是左子树
            while (node.getParent() != null
                    && node.getParent().getRight() == node){
                node = node.getParent();
            }
            // 1.node.getParent() == null
            // 2.node is left child of its parent
            return node.getParent();
        }
    }

    //返回右子树的第一个结点
    public TreeNode first(TreeNode node) {
        if (node == null){
            return null;
        }
        //一直向左，走到最后
        TreeNode curNode = node;
        while (curNode.getLeft() != null){
            curNode = curNode.getLeft();
        }
        return curNode;
    }

    //遍历
    public void traverse(TreeNode root){
        for (TreeNode node = first(root);node!=null;node=next(node)){
            System.out.print(node.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeCreator creator = new TreeCreator();
        SelectInOrderNextPoint in = new SelectInOrderNextPoint();

        TreeNode sapmleTree = creator.createSampleTree();
        in.traverse(sapmleTree);
        in.traverse(creator.createTree("",""));
        in.traverse(creator.createTree("A","A"));
        in.traverse(creator.createTree("AB","BA"));
        in.traverse(creator.createTree("ABCD","DCBA"));
        in.traverse(creator.createTree("ABCD","ABCD"));

    }

}
