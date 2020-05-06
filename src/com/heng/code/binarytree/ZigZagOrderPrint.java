package com.heng.code.binarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagOrderPrint {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here
        if(root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        deque.offerFirst(root);
        int layer = 0;
        while(!deque.isEmpty()) {
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                if(layer == 0) {
                    //at even level, we do it from right to left
                    TreeNode tmp = deque.pollLast();
                    list.add(tmp.val);
                    if(tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if(tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                }else {
                    // at odd level, we do it from left to right
                    TreeNode tmp = deque.pollFirst();
                    list.add(tmp.val);
                    if(tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if(tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                }
            }
            layer = 1 - layer;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeGenerator tree1 = new TreeGenerator();
                /*
                    20
                   /  \
                  15   25
                 / \   / \
                12 17 22 27
         */
        TreeNode root1 = tree1.getTestCompleteTree();
        ZigZagOrderPrint zigzag = new ZigZagOrderPrint();
        List<Integer> res = zigzag.zigZag(root1);
        System.out.println(res.toString());
    }
}
