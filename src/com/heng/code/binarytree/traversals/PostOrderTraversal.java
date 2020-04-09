package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeNode;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postOrderRecur(TreeNode root) {
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
        helper(root.right, res);
        res.add(root.val);

    }
}
