package com.heng.code.dp;

/**
 * Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.
 *
 * Return the arm length of the largest cross.
 *
 * Assumptions
 *
 * The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
 * Examples
 *
 * { {0, 0, 0, 0},
 *
 *   {1, 1, 1, 1},
 *
 *   {0, 1, 1, 1},
 *
 *   {1, 0, 1, 1} }
 *
 * the largest cross of 1s has arm length 2.
 */
public class LongestCross {


}

    /* from left to right
        1.M1[i][j] represents that [ from right to left] the length of longest consecutive ones,
        including input[i][j]
      fro, right to left
        2.M1[i][j] represents that [ from right to left] the length of longest consecutive ones,
        including input[i][j]
      from top down
        3.M1[i][j] represents that [ from right to left] the length of longest consecutive ones,
        including input[i][j]
      from bottom up
        4.M1[i][j] represents that [ from right to left] the length of longest consecutive ones,
        including input[i][j]
    */