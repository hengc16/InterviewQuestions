package com.heng.code.binarytree.traversals;

import com.heng.code.binarytree.TreeGenerator;
import com.heng.code.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //create a binary tree
        //             10
        //         7        11
        //      5    9          18
        PreOrderTraversal preOrder = new PreOrderTraversal();
        TreeGenerator testTree = new TreeGenerator();
        TreeNode root = testTree.getTestBinaryTree();

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

        //postOrder - traversal
        PostOrderTraversal postOrder = new PostOrderTraversal();
        //iterative
        res.clear();
        res = postOrder.postOrderIter(root);
        System.out.println(res.toString());
        //recursive
        res.clear();
        res = postOrder.postOrderRecur(root);
        System.out.println(res.toString());

    }
}
