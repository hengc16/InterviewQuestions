package com.heng.code.recursion;

import com.heng.code.binarytree.TreeGenerator;
import com.heng.code.binarytree.TreeNode;
import com.heng.code.binarytree.traversals.PreOrderTraversal;

import java.util.List;

/**
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.
 *
 * Examples
 *
 *         1
 *
 *       /    \
 *
 *     2        5
 *
 *   /   \
 *
 * 3      4
 *
 * is reversed to
 *
 *         3
 *
 *       /    \
 *
 *     2        4
 *
 *   /   \
 *
 * 1      5
 */

public class ReverseBinaryTree {
    public TreeNode reverse(TreeNode root) {
        // Write your solution here
        if(root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = reverse(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    /*
     *             10
     *            /  \
     *           7    11
     *          / \
     *         5   9
     */
    public static void main(String[] args) {
        ReverseBinaryTree reverseBinaryTree = new ReverseBinaryTree();
        TreeGenerator test1 = new TreeGenerator();
        TreeNode testNode = test1.getTestBinaryTree();
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        List<Integer> preOrderTree = preOrderTraversal.preOrderRecur(testNode);
        System.out.println("Binary tree before reverse: " + preOrderTree.toString());
        TreeNode reversedTree = reverseBinaryTree.reverse(testNode);
        System.out.println("BinaryTree after the reverse" + preOrderTraversal.preOrderIter(reversedTree).toString());
    }
}

/*
   4  5
  /  /
 3 - 2 - 1

    1
   / \
  2   5
 / \
3   4

dive deep to the very left node

return as new head

  2
 /  \
3    4

2 is the root at this level
root.left.right = root.right
root.left.left = root
root.left = null
root.right = null
return new head  down below

  3
 / \
2   4




*/