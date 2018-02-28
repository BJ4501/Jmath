package com.bj.MoocInterview.tree;

/**
 * 构建一个树
 * Created by BJ on 2018/2/27.
 */
public class TreeCreator {

    /**
     * 前序遍历
     * @param root 树根
     */
    public void preOrder(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.getValue()); //先遍历根
        preOrder(root.getLeft()); //再左子树
        preOrder(root.getRight()); //再右子树
    }

    /**
     * 中序遍历
     * @param root 树根
     */
    public void inOrder(TreeNode root){
        if (root == null){
            return;
        }
        inOrder(root.getLeft()); //先左子树
        System.out.print(root.getValue());//再遍历根
        inOrder(root.getRight()); //再右子树
    }

    /**
     * 后序遍历
     * @param root 树根
     */
    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.getLeft()); //先左子树
        postOrder(root.getRight()); //再右子树
        System.out.print(root.getValue());//再遍历根
    }

    public TreeNode createSampleTree() {
        TreeNode root = new TreeNode('A');
        root.setLeft(new TreeNode('B'));
        root.getLeft().setLeft(new TreeNode('D'));
        root.getLeft().setRight(new TreeNode('E'));
        root.getLeft().getRight().setLeft(new TreeNode('G'));
        root.setRight(new TreeNode('C'));
        root.getRight().setRight(new TreeNode('F'));
        return root;
    }

    /**
     * 构造后序遍历--使用树
     * @param preOrder 前序
     * @param inOrder 中序
     * @return 后序
     */
    public TreeNode createTree(String preOrder, String inOrder){
        if(preOrder.isEmpty()){
            return null;
        }

        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);//确定树根的位置 leftSize == rootIndex

        //构建新树根
        TreeNode root = new TreeNode(rootValue);
        //1+leftSize:半开半闭区间
        root.setLeft(createTree(preOrder.substring(1,1 + rootIndex),
                                inOrder.substring(0, rootIndex)));

        //这里注意数组的开始是从0开始，不要乱了
        root.setRight(createTree(preOrder.substring(1 + rootIndex),
                                 inOrder.substring(1 + rootIndex)));//中序遍历需要+1因为需要跳过根节点

        return root;
    }

    /**
     * 构造后序遍历-不使用树
     * @param preOrder 前序
     * @param inOrder 中序
     * @return 后序
     */
    public String createTreePostOrder(String preOrder, String inOrder){
        if(preOrder.isEmpty()){
            return "";
        }

        char rootValue = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(rootValue);//确定树根的位置 leftSize == rootIndex

        //不构建树，直接将内容转化为String
        return createTreePostOrder(preOrder.substring(1,1 + rootIndex),inOrder.substring(0, rootIndex))+
                createTreePostOrder(preOrder.substring(1 + rootIndex), inOrder.substring(1 + rootIndex)) + rootValue;
    }

    public static void main(String[] args) {
        TreeCreator c = new TreeCreator();
        TreeNode tn = c.createTree("ABDEGCF","DBGEACF");
        c.postOrder(tn);
        System.out.println();
        TreeNode tn1 = c.createTree("","");
        c.postOrder(tn1);
        System.out.println();
        TreeNode tn2 = c.createTree("A","A");
        c.postOrder(tn2);
        System.out.println();
        TreeNode tn3 = c.createTree("AB","BA");
        c.postOrder(tn3);
        System.out.println();

        System.out.println("-------");
        System.out.println(c.createTreePostOrder("ABDEGCF","DBGEACF"));
        System.out.println(c.createTreePostOrder("",""));
        System.out.println(c.createTreePostOrder("A","A"));
        System.out.println(c.createTreePostOrder("AB","BA"));

    }

}
