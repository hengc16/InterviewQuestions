package com.heng.code.dp;

/**
 * Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.
 *
 * Assumptions
 *
 * The given matrix is not null and guaranteed to be of size N * N, N >= 0
 * Examples
 *
 * { {0, 0, 0, 0},
 *
 *   {1, 1, 1, 1},
 *
 *   {0, 1, 1, 1},
 *
 *   {1, 0, 1, 1}}
 *
 * the largest square of 1s has length of 2
 */
public class maxSquare {
    public int largest(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) {
            return 0;
        }
        int globalMax = 0;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    m[i][j] = matrix[i][j] == 1 ? 1 : 0;
                }else if (matrix[i][j] == 1) {
                    m[i][j] = Math.min(m[i][j - 1]+1, m[i - 1][j]+1);
                    m[i][j] = Math.min(m[i][j], m[i-1][j-1]+1);
                }
                globalMax = Math.max(globalMax, m[i][j]);
            }


        }
        return globalMax;
    }
}
/**
 * M[i][j] represents the max size of square with (i,j) as the bottom right corner.
 * if A[i][j] = 0    :  M[i][j] = 0
 * else :               M[i][j] = min( M[i-1][j-1], M[i-1][j], M[i][j-1])
 * in a box like :
 * 0 0 0 0
 * 1 1 1 0
 * 1 1 1 1
 * 1 1 1 1
 *
 * the M we record is
 * 0 0 0 0
 * 0 0 0 0
 * 0 1 1 0
 * 0 1 2 1
 *
 *
 *
 *
 *
 * Time: O(n^2)
 * Space: O(n^2) can be optimized to O(n)  since we only care about the  top left  top and left  3 elements .
 */