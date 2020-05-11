package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*            1
*          /   \
*        2      3
*      /  \    /   \
*    4    5   6     7
*
*  output = 1 2 3 4 5 6 7
* or
* output: 1
*         2 3
*         4 5 6 7
*
* */
public class LevelOrderTraverse {
    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
