package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversal {
    // iterative way to do preOrder
    public List<Integer> preOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            res.add(cur.val);
        }
        return res;
    }
    // pre order recursively
    public List<Integer> preOrderRecur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preOrderHelper(root, res);
        return res;

    }

    private void preOrderHelper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preOrderHelper(root.left, res);
        preOrderHelper(root.right, res);
    }



}
