package com.heng.code.dfs;
/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
 */

import java.util.ArrayList;
import java.util.List;

public class AllSubset {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if(set == null){
            return res;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(0,array, sb, res);
        return res;
    }
    private void helper (int index, char[] array, StringBuilder sb, List<String> res) {
        if(index == array.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(array[index]);
        helper(index + 1, array, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        helper(index + 1, array, sb, res);
    }
}
