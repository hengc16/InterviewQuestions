package com.heng.code.heap;

/**
 * common implementation of a heap is using complete binary tree, in order to access their parent and child using
 * index.
 * exp.  left child of index i  is  2 * i + 1
 *       right child of index i   is 2 * i + 2
 *       parent of index i  is  (i - 1 ) / 2;
 *       the root of the tree is at index 0 ;
 */
public class HeapImp {
    private int[] array;
    private int size;
    public HeapImp(int[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("can not be null");
        }
        this.array = array;
        size = array.length;
        heapif();
    }

    private void heapif() {

    }

    private void percolateUp() {

    }
}
