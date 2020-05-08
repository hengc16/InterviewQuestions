package com.heng.code.binarytree.binarysearchtree;

import com.heng.code.binarytree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;

public class constructBSTFromArray {
    public TreeNode sortedArrayToBST(int[] num) {
        // Write your solution here

        if (num.length == 0) {
            return null;
        }
        Arrays.sort(num);
        return helper(num, 0, num.length);

    }

    private TreeNode helper(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array, left, mid - 1);
        root.right = helper(array, mid + 1, right);
        return root;
    }
}
