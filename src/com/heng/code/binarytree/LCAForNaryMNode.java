package com.heng.code.binarytree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given M nodes in a K-nary tree, find their lowest common ancestor.
 *
 * Assumptions
 *
 * - M >= 2.
 *
 * - There is no parent pointer for the nodes in the K-nary tree.
 *
 * - The given M nodes are guaranteed to be in the K-nary tree.
 *
 * Examples
 *
 *         5
 *
 *       /   \
 *
 *      9   12
 *
 *    / | \      \
 *
 *   1 2 3     14
 *
 *
 *
 * The lowest common ancestor of 2, 3, 14 is 5.
 *
 * The lowest common ancestor of 2, 3, 9 is 9.
 */
public class LCAForNaryMNode {
    public KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
        // Write your solution here
        Set<KnaryTreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }
    private KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
        if(root == null || set.contains(root)) {
            return root;
        }
        KnaryTreeNode found = null;
        for(KnaryTreeNode child : root.children) {
            KnaryTreeNode node = helper(child, set);
            if(node == null) {
                continue;
            }
            if(found == null) {
                found = node;
            }else {
                return root;
            }
        }
        return found;
    }
}

/*
    pre-process ： 把要找的node 放在一个hashset里
    从上往下走这个树， 对每个node进行遍历，如果这个node是set里的一个 可以不用往下走了，返回回去
    当有2个node返回回来时，我们就找到了所以node的公共祖先。 因为我们是从上到下，从左到右来遍历的。


*          5
 *
 *       /   \
 *
 *      9      12
 *
 *    / | \      \
 *
 *   1 2 3        14
* */