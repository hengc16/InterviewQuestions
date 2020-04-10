package com.heng.code.binarytree.binarysearchtree;

import com.heng.code.binarytree.TreeNode;

public class BinarySearchTree {
    public TreeNode search(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }
        if (root.val < target) {
            return search(root.right, target);
        } else {
            return search(root.left, target);
        }
    }

    public TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.val < key) {
            root.left = insert(root.left, key);
        } else if (root.val > key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = delete(root.right, key);
        } else if (root.val > key) {
            root.left = delete(root.left, key);
        } else {                                           // if root.val == key   the deletion part occur
            if (root.left == null) {                       // case1  no left child,  simply return the right child
                return root.right;
            } else if (root.right == null) {               // case 2  no right child, simply return the left child
                return root.left;
            }                                               // case3   have both child,  return either the left largest
            TreeNode minNode = findMin(root.right);        // or the right smallest, here we do the right smallest
            root.val = minNode.val;                        // let the deletion node = to the right smallest
            root.right = delete(root.right, root.val);     // then use the same deletion logic to delete the right
        }                                                  // smallest.
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
