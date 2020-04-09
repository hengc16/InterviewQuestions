package com.heng.code.binarytree;

public class Main {
    public static void main(String[] args) {
        //create some sample trees
        TreeGenerator treeGenerator = new TreeGenerator();
        TreeNode root1 = treeGenerator.getTestBalancedTree();
        TreeNode root2 = treeGenerator.getTestOnePathTree();
        TreeNode root3 = treeGenerator.getSymmetricTree();
        //test get height methods
        HeightOfBinaryTree testHeight = new HeightOfBinaryTree();
        int root1Height = testHeight.findHeight(root1);
        System.out.println("tree1 height = " + root1Height);
        int root2Height = testHeight.findHeight(root2);
        System.out.println("tree2 height = " + root2Height);

        //test is balance function
        CheckIfBalance checkIfBalance = new CheckIfBalance();
        System.out.println("tree1 is balanced? " + checkIfBalance.isBalance(root1));
        System.out.println("tree2 is balanced? " + checkIfBalance.isBalance(root2));

        //test is symmetric function
        CheckIfSymmetric checkIfSymmetric =new CheckIfSymmetric();
        System.out.println("tree1 is symmetric? " + checkIfSymmetric.isSymmetric(root1));
        System.out.println("tree3 is symmetric " + checkIfSymmetric.isSymmetric(root3) );

        //test is BST function
        CheckIfBST checkIfBST = new CheckIfBST();
        System.out.println("tree1 is BST " + checkIfBST.isBST(root1));
        System.out.println("tree3 is BST " + checkIfBST.isBST(root3));
    }
}
