package com.heng.code.binarytree;

public class CheckIfBST {
    public boolean isBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean isBST(TreeNode root, int min, int max) {
        if(root == null ) {
            return true;
        }
        if(root.val <= min || root.val >= max) {
            return false;
        }
        return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
    }
}
