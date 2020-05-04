package com.heng.code.array;

import com.heng.code.recursion.SpiralOrderTraversal;
/**
 * Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.
 *
 * Assumptions
 *
 * The 2D array is not null and has size of N * N where N >= 0
 * Examples
 *
 * { {1,  2,  3},
 *
 *   {4,  5,  6},
 *
 *   {7,  8,  9} }
 *
 * the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 *
 */
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
        if (matrix == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        helper(matrix, 0, matrix.length, res);
        return res;

    }

    private void helper(int[][] matrix, int start, int size, List<Integer> res) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(matrix[start][start]);
            return;
        }
        //horizontal top  [start to size - 1)
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[start][start + i]);
        }
        //vertical right [start to size - 1) vertically
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[start + i][start + size - 1]);
        }
        //horizontal bottom from right ot left [size-1 to start + 1]
        for (int i = size - 1; i > 0; i--) {
            res.add(matrix[start + size - 1][start + i]);
        }
        //vertically left  from bottom to the top [size - 1 to start + 1]
        for (int i = size - 1; i > 0; i--) {
            res.add(matrix[start + i][start]);
        }
        helper(matrix, start + 1, size - 2, res);
    }

    // m is the height, n is the length.
    private void helper2(int[][] matrix, int start, int m, int n, List<Integer> res) {
        if (m <= 0 || n <= 0) {
            return;
        }
        if (m == 1 && n == 1) {
            res.add(matrix[start][start]);
            return;
        }
        //horizontal top  [start to size - 1)
        for (int i = 0; i < n - 1; i++) {
            res.add(matrix[start][start + i]);
        }
        //vertical right [start to size - 1) vertically
        for (int i = 0; i < m - 1; i++) {
            res.add(matrix[start + i][start + n - 1]);
        }
        //horizontal bottom from right ot left [size-1 to start + 1]
        for (int i = n - 1; i > 0; i--) {
            res.add(matrix[start + m - 1][start + i]);
        }
        //vertically left  from bottom to the top [size - 1 to start + 1]
        for (int i = m - 1; i > 0; i--) {
            res.add(matrix[start + i][start]);
        }
        helper2(matrix, start + 1, m - 2, n - 2, res);
    }

    public static void main(String[] args) {
        SpiralOrderTraversalI traver1 = new SpiralOrderTraversalI();
        int[][] martix = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12},{13,14,15,16,17,18}};
        List<Integer> res = traver1.spiral(martix);
        System.out.println(res.toString());
        res.clear();
        traver1.helper2(martix, 0, martix.length, martix[0].length, res);
        System.out.println(res.toString());
    }
//     1  2  3  4  5  6
//     7  8  9 10 11 12
//    13 14 15 16 17 18
//
//    n = 6
//    m = 3

}
