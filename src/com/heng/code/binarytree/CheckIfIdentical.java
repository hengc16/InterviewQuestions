package com.heng.code.binarytree;

public class CheckIfIdentical {
    public boolean isIdentical (TreeNode root) {
        if(root == null) {
            return true;
        }
        return isIdentical(root.left, root.right);
    }
    private boolean isIdentical(TreeNode one, TreeNode two) {
        if(one == null && two == null) {
            return true;
        }else if(one == null || two == null) {
            return false;
        }else if(one.val != two.val) {
            return false;
        }
        return isIdentical(one.left, two.left) && isIdentical(one.right, two.right) ||
                isIdentical(one.left, two.right) && isIdentical(one.right, two.left);
    }
}

/*
        5            5
       / \          / \
      3    8       8    3
     /\                /  \
    1  4              1    4
 the tree above is tweaked identical


 */