package com.heng.code.dp;

/**
 * Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.
 *
 * Assumptions
 *
 * Both strings are not null
 * Examples
 *
 * string one: “sigh”, string two : “asith”
 *
 * the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
 */
public class EditDistance {
    public int editDistance(String one, String two) {
        // Write your solution here
        int[][] m = new int[one.length() + 1][two.length() + 1];
        for(int i = 0; i <= one.length(); i++) {
            for(int j = 0; j <= two.length(); j++) {
                if(i == 0){
                    m[i][j] = j;
                }else if (j == 0) {
                    m[i][j] = i;
                }else if (one.charAt(i -1) == two.charAt(j - 1)) {
                    m[i][j] = m[i - 1][j -1];
                }else{
                    m[i][j] = Math.min(m[i-1][j] + 1, m[i][j - 1] + 1);
                    m[i][j] = Math.min(m[i -1][j -1] + 1, m[i][j]);
                }
            }
        }
        return m[one.length()][two.length()];
    }
  /*
  M[i][j] represents the minimum number of actions to transform the first i letters of S1(s1[0....i-1]) to the first j letters of S2(s2[0..j-1])
  if s1[i-1] == s2[j-1]   :  M[i][j] = M[i-1][j-1]
  else:               M[i][j] = min(M[i-1][j-1], M[i-1][j], M[i][j-1])

  2D  M[i][j]
  in order to fill in a value M[i][j], we must know the value to:
    1.my top-left position
    2. upper-value;
    3. left value.
  fill the M[i][j] from top-down, left to right.
    3 4
    3 ?  ? will be 4 in this case.


  Time: O(m * n)
  space: O(m * n)
  */
}
