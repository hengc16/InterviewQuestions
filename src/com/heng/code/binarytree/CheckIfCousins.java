package com.heng.code.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Check if two nodes are cousins in a Binary Tree
 *
 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
 *
 * Two nodes are cousins of each other if they are at same level and have different parents.
 *
 * Example:
 *
 *                       6
 *
 *                   /     \
 *
 *                3            5
 *
 *             /     \      /    \
 *
 *          7         8    1       2
 * 7 and 1, result is TRUE
 *
 * 3 and 5, result is FALSE
 *
 * 7 and 5, result is FALSE
 */
public class CheckIfCousins {
    public boolean isCousins(TreeNode root, TreeNode a, TreeNode b) {

        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode xParent = null, yParent = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    if(node.left.val == a.val){
                        xParent = node;
                    }
                    if(node.left.val == b.val){
                        yParent = node;
                    }
                }
                if(node.right != null){
                    queue.offer(node.right);
                    if(node.right.val == a.val){
                        xParent = node;
                    }
                    if(node.right.val == b.val){
                        yParent = node;
                    }
                }
                size--;
                if(xParent != null && yParent != null){
                    break;
                }
            }
            if(xParent != null && yParent != null){
                return xParent != yParent;
            }
            if((xParent != null && yParent == null) || (xParent == null && yParent != null))
            {
                return false;
            }
        }
        return false;
    }
}
