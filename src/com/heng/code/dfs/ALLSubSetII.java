package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string with no duplicate characters, return a list with all permutations of the characters.
 *
 * Assume that input string is not null.
 *
 * Examples
 *
 * Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
 *
 * Set = "", all permutations are [""]
 */
public class ALLSubSetII {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(input == null){
            return res;
        }
        char[] array = input.toCharArray();
        helper(0, array, sb, res);
        return res;
    }
    private void helper( int index, char[] array, StringBuilder sb, List<String> res){
        //base case 进入最后一层
        if(index == array.length- 1){
            sb.append(array[index]);
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(array[index]);
        sb.append('_');
        helper(index + 1, array, sb, res);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        sb.append(array[index]);
        helper(index + 1, array,sb, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        ALLSubSetII test1 = new ALLSubSetII();
        List<String> res = test1.permutations("abc");
        System.out.println(res.toString());
    }
}
/*
 *                               abc
 *                          /         \
 *                        a_bc         abc
 *                       /  \          / \
 *                 a_b_c    a_bC     ab_c  abc
 *
 *               T: O(2^n-1 * n)
 *               S: O(n)
 *
 *
 *
 */
