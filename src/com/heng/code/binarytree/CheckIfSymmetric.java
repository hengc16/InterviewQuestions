package com.heng.code.binarytree;

public class CheckIfSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode one, TreeNode two) {
        if(one == null && two == null) {
            return true;
        }else if (one == null || two == null) {
            return false;
        }else if (one.val != two.val) {
            return false;
        }
        return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
    }
}
