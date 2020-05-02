package com.heng.code.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrixII {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) res.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) res.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) res.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) res.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
