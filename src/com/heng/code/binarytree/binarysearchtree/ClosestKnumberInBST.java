package com.heng.code.binarytree.binarysearchtree;

import com.heng.code.binarytree.TreeGenerator;
import com.heng.code.binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * In a binary search tree, find k nodes containing the closest numbers to the given target number. return them in sorted array
 *
 * Assumptions:
 *
 * The given root is not null.
 * There are no duplicate keys in the binary search tree.
 * Examples:
 *
 *     5
 *
 *   /    \
 *
 * 2      11
 *
 *      /    \
 *
 *     6     14
 *
 * closest number to 4 is 5
 *
 * closest number to 10 is 11
 *
 * closest number to 6 is 6
 */
public class ClosestKnumberInBST {
    public int[] closestKValues(TreeNode root, double target, int k) {
        // Write your solution here
        if(k <= 0) {
            return new int[0];
        }
        Deque<Integer> queue = new LinkedList<>();
        helper(root, target, k, queue);
        int[] res = new int[queue.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    private void helper(TreeNode root, double target, int k, Deque<Integer> queue) {
        if(root == null) {
            return;
        }
        helper(root.left, target, k, queue);
        if(queue.size() < k) {
            queue.offer(root.val);
        }else {
            if(Math.abs(target - root.val) < Math.abs(target - queue.peek())) {
                queue.poll();
                queue.offer(root.val);
            }else {
                return;
            }
        }
        helper(root.right, target, k, queue);
    }

    public static void main(String[] args) {
        /*
                    10
                  /    \
                5       15
              /  \      /  \
            2      6   12    17
         */
        TreeGenerator BST = new TreeGenerator();
        TreeNode root1 = BST.getBST();
        int target = 15;
        int k = 5;
        int[] res = new int[k];
        ClosestKnumberInBST test1 = new ClosestKnumberInBST();
        res = test1.closestKValues(root1,target,k);
        for(int a : res ) {
            System.out.println(a);
        }
    }
}
/*
* 整体是一个inorder traversal， 维护一个长度为k的sliding window 在bst上， 因为bst inorder traversal 是满足递增的
* 可以用queue来维护这个sliding window， 如果queue的size 小于k的时候，直接加。
* 如果queue的size == k 了， 要判断需不需要加， 通过拿window 左边的数和 将要加入的数 去和target做对比， min dif小的那个留下。
* 如果发现新来的不如 window左边的那个数， 可以直接返回了， 因为新来的后面的数还不如新来的，只会越来越大。
*
*
* Time: O(n)
* Space : O(k + h)
*
*
* */