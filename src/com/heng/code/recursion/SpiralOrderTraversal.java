package com.heng.code.recursion;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversal {
    public List<Integer> spiral (int [][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        recursiveTraverse(matrix, 0, n, res);
        return res;

    }
    //  1 2 3
    //  4 5 6
    //  7 8 9     12   36   98  74    on the first layer
    private void recursiveTraverse(int[][] matrix, int start, int n, List<Integer> res) {
        if(n == 0) {
            return;
        }
        if(n == 1) {
            res.add(matrix[start][start]);
            return;
        }
        // [start  .... n - 1)  exp. if  1 2 3,   res will add only 1 and 2.
        for(int i = 0; i < n - 1; i++) {
            res.add(matrix[start][start + i]);
        }
        //  3 6 9    add 3 6  to the res.
        for(int i = 0; i < n - 1; i++) {
            res.add(matrix[start + i][n - 1]);
        }
        // 9 and 8  to the res
        for(int i = n - 1; i > 0; i--) {
            res.add(matrix[n - 1] [start + i]);
        }
        // add 7 4 to the res
        for(int i = n - 1; i > 0; i--) {
            res.add(matrix[start+i][start]);
        }
        //after finishing the task of current layer, we dive to the next layer. the smaller problem
        recursiveTraverse(matrix, start + 1, n -2, res);
    }

    public static void main(String[] args) {
        SpiralOrderTraversal sot = new SpiralOrderTraversal();
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = new ArrayList<>();
        res = sot.spiral(test1);
        System.out.println(res.toString());
    }
}
