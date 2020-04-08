package com.heng.code.binarytree.traversals;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //create a binary tree
        //             10
        //         7        11
        //      5    9          18
        PreOrderTraversal preOrder = new PreOrderTraversal();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
        root.right.right = new TreeNode(18);

        //use preOrder iterative way to solve
        List<Integer> res = new ArrayList<>();
        res = preOrder.preOrderIter(root);
        System.out.println(res.toString());            // 10 7 5 9 11 18
        //use preOrder recursive way to solve;
        res.clear();
        res = preOrder.preOrderRecur(root);
        System.out.println(res.toString());           // 10 7 5 9 11 18

        //inOder -traversal
        InOrderTraversal inorder = new InOrderTraversal();
        //iterative
        res.clear();
        res = inorder.inOrderIter(root);
        System.out.println(res.toString());
        //recursive way
        res.clear();
        res = inorder.inOrderRecur(root);
        System.out.println(res.toString());

    }
}
