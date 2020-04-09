package com.heng.code.binarytree;


public class HeightOfBinaryTree {
    public int findHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        return Math.max(findHeight(root.left) , findHeight(root.right)) + 1;
    }
}
/*
Time: O(n)   n is the total number of node in the tree
Space: O(n) or O(height)      tree with one path
 */
