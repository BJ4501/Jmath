package com.bj.MoocInterview.tree;

/**
 * 树的节点
 * Created by BJ on 2018/2/27.
 */
public class TreeNode {

    private char value;

    private TreeNode left;

    private TreeNode right;

    private TreeNode parent;

    public TreeNode(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
        //当设置一个左结点的时候，赋值左结点父亲
        //在设置left和right的时候，会出现null的情况，需要判断一下
        if (this.left != null){
            this.left.setParent(this);
        }
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
        if (this.right != null){
            this.right.setParent(this);
        }
    }

    public TreeNode getParent() {
        return parent;
    }

    private void setParent(TreeNode parent) {
        this.parent = parent;
    }
}
