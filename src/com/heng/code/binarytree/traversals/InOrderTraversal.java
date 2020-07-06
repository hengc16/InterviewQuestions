package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InOrderTraversal {
    public List<Integer> inOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    List<Integer> inOrderRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    public static void main(String[] args) {
        /*              10
                    /           \
        *         5                15
              /      \           /    \
           2          7          12       20
             \
               4
              /
        *    3
        *
        * */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> res = inOrderTraversal.inOrderRecur(root);
        System.out.println(res.toString());
    }
}
