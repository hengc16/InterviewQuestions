package com.heng.code.binarytree;

/**
 * Given two keys in a binary search tree, find their lowest common ancestor.
 *
 * Assumptions
 *
 * There is no parent pointer for the nodes in the binary search tree
 *
 * There are no duplicate keys in the binary search tree
 *
 * The given two nodes are guaranteed to be in the binary search tree
 *
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      2     12
 *
 *    /  \      \
 *
 *   1    3      14
 *
 * The lowest common ancestor of 1 and 14 is 5
 *
 * The lowest common ancestor of 1 and 3 is 2
 */
public class LCA {
    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        if(root == null || root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right,p, q);
        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
