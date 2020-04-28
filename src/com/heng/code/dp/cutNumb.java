package com.heng.code.dp;

/**
 * How to cut/split the number into a minimum number of items such that each item is equal to an integer's square value.
 * <p>
 * For example
 * <p>
 * 4 can be split to 1+1+1+1 (4 items) or 2^2 (1 item, which is the solution)
 * Return 1
 * 10 can be split to two items 3^2 + 1^2 (solution) or four items 2^2 + 2^2 + 1^2 +1^2
 * Return 2
 */
public class cutNumb {
    public int cutNumb(int num) {
        int[] M = new int[num + 1];
        M[1] = 1;
        for(int i = 2; i< num; i++) {
            M[i] = i;
            for(int j = 1; j * j <= i; j++) {
                M[i] = Math.min(M[i], 1 + M[i-j*j]);
            }
        }
        return M[num];
    }
}
// Time : O(n^1.5)  outter loop = n ;   inner loop = sqrt(n)
// O(n) space