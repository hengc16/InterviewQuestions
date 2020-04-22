package com.heng.code.binarytree;


import com.sun.source.tree.Tree;

/**
 * A class that pre-write some tree for future test case.
 */
public class TreeGenerator {
    public TreeNode getTestBinaryTree(){
        /*
         *             10
         *            /  \
         *           7    11
         *          / \
         *         5   9
         */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
//        root.right.right = new TreeNode(18);
        return root;
    }
    public TreeNode getTestBalancedTree(){
        /*
                    15
                   /  \
                  10   19
                 / \     \
                5   12    22
         */
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(19);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(22);
        return root;
    }
    public TreeNode getTestCompleteTree(){
        /*
                    20
                   /  \
                  15   25
                 / \   / \
                12 17 22 27
         */
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(15);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(17);
        root.right.left = new TreeNode(22);
        root.right.right = new TreeNode(27);
        return root;
    }

    public TreeNode getTestOnePathTree(){
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(45);
        root.left.left = new TreeNode(40);
        root.left.left.left = new TreeNode(35);
        root.left.left.left.left= new TreeNode(30);
        root.left.left.left.left.left = new TreeNode(25);
        return root;
    }

    public TreeNode getSymmetricTree(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.left.right = new TreeNode (3);
        root.right.left = new TreeNode(3);
        return root;
    }

}
