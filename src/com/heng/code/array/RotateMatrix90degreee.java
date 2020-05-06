package com.heng.code.array;

import java.util.Arrays;
import java.util.List;

/**
 * Rotate an N * N matrix clockwise 90 degrees.
 *
 * Assumptions
 *
 * The matrix is not null and N >= 0
 * Examples
 *
 * { {1,  2,  3}
 *
 *   {8,  9,  4},
 *
 *   {7,  6,  5} }
 *
 * after rotation is
 *
 * { {7,  8,  1}
 *
 *   {6,  9,  2},
 *
 *   {5,  4,  3} }
 */
public class RotateMatrix90degreee {
    public void rotate(int[][] matrix) {
        // Write your solution here
        if(matrix == null) {
            return;
        }
        helper(matrix, 0, matrix.length);
    }
    private void helper(int[][] matrix, int start, int size ) {
        if(size <= 1) {
            return;
        }
        //swap 1 2   to  location of 3 , 4
        for(int i = 0; i < size - 1; i++) {
            swap(matrix, start, start + i, start + i, size + start - 1);
        }
        // swap 3 4  to location of 5 6
        for(int i = 0; i < size - 1; i++) {
            swap(matrix, start, start + i, start + size - 1, start + size - 1 - i );
        }
        // swap 5 6 to location of 7 8
        for(int i = 0; i < size - 1; i++) {
            swap(matrix, start, start + i, start + size - 1 - i, start);
        }
        helper(matrix, start + 1, size -2);
    }
    private void swap (int[][] matrix, int x1, int x2, int y1, int y2) {
        int tmp = matrix[x1][x2];
        matrix[x1][x2] = matrix[y1][y2];
        matrix[y1][y2] = tmp;
    }
    private  void print (int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();;
        }
    }

    public static void main(String[] args) {
        RotateMatrix90degreee rotate = new RotateMatrix90degreee();
        int[][] matrix = new int[][]{{1,2,3},{8,9,4},{7,6,5}};
        rotate.rotate(matrix);
        rotate.print(matrix);

    }
}
/*

*/

