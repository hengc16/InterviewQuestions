package com.heng.code.binarytree;

public class CheckIfBalance {
    public boolean isBalance(TreeNode root){
        if(root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    private int getHeight(TreeNode root) {
        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        return heightOfBinaryTree.findHeight(root);
    }
}

/*
    Tree has logN height if its balanced
    there's O(n) operations in each node
    thus, total time = n + n/2 *2 + n/4*4 +.. = O(n log n)
 */
