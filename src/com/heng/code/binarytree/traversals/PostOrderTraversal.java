package com.heng.code.binarytree.traversals;

import java.util.*;

public class PostOrderTraversal {
    public List<Integer> postOrderIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(cur.right != null){
                stack.push(cur.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
