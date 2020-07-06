package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfFactors {
    public List<List<Integer>> factors(int n) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prefix = new ArrayList<>();
        prefix.add(n);
        res.add(new ArrayList<Integer>(prefix));
        prefix.remove(prefix.size() - 1);
        helper(2, 1, n, prefix, res);
        return res;
    }
    private void helper(int start, int totalSofar, int n, List<Integer> prefix, List<List<Integer>>res) {
        if(totalSofar > n) {
            return;
        }
        if(totalSofar == n){
            res.add(new ArrayList<Integer> (prefix));
            return;
        }
        //分叉，每个i 都是一个可能的factor
        for(int i = start; i <= n/2; i++){
            if(i * totalSofar > n) {
                break;
            }
            //判断当前i是不是n的factor
            if(n % i == 0) {
                prefix.add(i);
                helper(i, i * totalSofar, n, prefix, res);
                prefix.remove(prefix.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationsOfFactors combs = new CombinationsOfFactors();
        List<List<Integer>> res = combs.factors(12);
        System.out.println(res.toString());

    }
}

