package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;
/*
Given an integer number, return all possible combinations of the factors that can multiply to the target number.

Example

Give A = 24

since 24 = 2 x 2 x 2 x 3

              = 2 x 2 x 6

              = 2 x 3 x 4

              = 2 x 12

              = 3 x 8

              = 4 x 6

your solution should return

{ { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }

note: duplicate combination is not allowed.
 */
public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if(target <= 1){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(0, target, factors, cur, res);
        return res;
    }
    private void helper(int index, int target, List<Integer> factors, List<Integer> cur, List<List<Integer>> res) {
        //base case
        if(index == factors.size()) {
            if(target == 1) {
                res.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        helper(index + 1, target, factors, cur, res);
        int factor = factors.get(index);
        int count = 0;
        while( target % factor == 0) {
            count++;
            cur.add(factor);
            target /= factor;
            helper(index + 1, target, factors, cur, res);
        }
        for(int i = 0; i < count; i++) {
            cur.remove(cur.size() - 1);
        }


    }
    private List<Integer> getFactors(int target) {
        List<Integer> factors = new ArrayList<>();
        for(int i = target / 2; i > 1; i--) {
            if(target % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }
}
