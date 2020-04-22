package com.heng.code.recursion;

import com.heng.code.binarytree.TreeNode;

/**
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
 *
 * Note:
 * A subtree must include all of its descendants.
 * Here's an example:
 *
 *     10
 *     / \
 *    5  15
 *   / \   \
 *  1   8   7
 * The Largest BST Subtree in this case is the highlighted one.
 * The return value is the subtree's size, which is 3.
 *
 * Follow up:
 * Can you figure out ways to solve it with O(n) time complexity?
 */
public class LargestBSTsubTree {
    public int largestBST(TreeNode root) {
        if(root == null) {
            return 0;
        }
        HelperNode res = largest(root);
        return res.size;
    }
    private HelperNode largest (TreeNode root) {
        if(root == null) {
            return new HelperNode();
        }
        HelperNode left = largest(root.left);
        HelperNode right = largest (root.right);

        HelperNode cur = new HelperNode();
        //case 1: if either the left child or the right child is not bst,  or the cur is not a bst(not in range)
        // update the cur node size with the max size from its left and right child
        if(!left.isBST || !right.isBST ||( left.max > root.val || root.val >= right.min)) {
            cur.isBST = false;
            cur.size = Math.max(left.size, right.size);
            return cur;
        }
        //case 2: if is bst
        // update the size , min ,max , isBST
        cur.isBST = true;
        cur.size = left.size + right.size + 1;
        cur.min = root.left != null ? left.min : root.val;
        cur.max = root.right != null ? right.max : root.val;
        return cur;
    }
    class HelperNode {
        int min;
        int max;
        boolean isBST;
        int size;
        HelperNode(){
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }
}
