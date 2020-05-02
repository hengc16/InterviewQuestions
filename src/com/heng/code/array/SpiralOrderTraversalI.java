package com.heng.code.array;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraversalI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        /**
         [1,2,3],
         [4,5,6],
         [7,8,9],
         print  12 36 98 74 5
         */
        if(matrix == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        helper(matrix, 0, matrix.length, res);
        return res;

    }
    private void helper(int[][]matrix,int start,int size,List<Integer> res) {
        if(size == 0) {
            return;
        }
        if(size == 1) {
            res.add(matrix[start][start]);
            return;
        }
        //horizontal top  [start to size - 1)
        for(int i = 0; i < size - 1; i++) {
            res.add(matrix[start][start + i]);
        }
        //vertical right [start to size - 1) vertically
        for(int i = 0; i < size - 1; i++) {
            res.add(matrix[start + i][start + size - 1]);
        }
        //horizontal bottom from right ot left [size-1 to start + 1]
        for(int i = size - 1; i > 0; i--) {
            res.add(matrix[start + size - 1][start + i]);
        }
        //vertically left  from bottom to the top [size - 1 to start + 1]
        for(int i = size - 1; i > 0; i--) {
            res.add(matrix[start + i][start]);
        }
        helper(matrix, start + 1, size - 2, res);
    }
}
