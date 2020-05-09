package com.heng.code.binarytree;



import java.util.List;

/**
 * implement a solution to parse a ternay expression into a tree. return the root of the constructed tree;
 * example    a?b:c   ->     a
 *                          / \
 *                         b   c
 *
 */
class Node{
    char data;
    Node left;
    Node right;
    public Node(char item) {
        data = item;
        left = null;
        right = null;
        }
}
public class ConstructTree {

    public Node constructTree(String input){
        if(input == null || input.length() == 0) {
            return null;
        }
        return helper(input.toCharArray(), 0);
    }

    private Node helper(char[] array, int index) {
        if(index >= array.length) {
            return null;
        }
        Node root = new Node(array[index]);
        ++index;
        if(index < array.length && array[index] == '?') {
            root.left = helper(array, index + 1);
        }
        else if ( index < array.length) {
            root.right = helper(array, index + 1);
        }
        return root;
    }
    private void preOrder(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        ConstructTree constructTree = new ConstructTree();
        Node root = constructTree.constructTree("1?2?3:4:5");
        constructTree.preOrder(root);

    }

}
