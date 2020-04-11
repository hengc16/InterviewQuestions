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
public class AllPermutation {
    public List<String> permutations(String input) {
        // Write your solution here
        List<String> res = new ArrayList<>();
        if(input == null){
            return res;
        }
        char[] array = input.toCharArray();
        helper(0, array, res);
        return res;
    }
    private void helper( int index, char[] array, List<String> res){
        //进入最后一层
        if(index == array.length){
            res.add(new String(array));
            return;
        }
        for(int i = index; i < array.length; i++) {
            //从当前层的第一个开始
            swap(array, i, index);
            helper(index + 1, array, res);
            swap(array, i, index);
        }
    }
    private void swap (char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
