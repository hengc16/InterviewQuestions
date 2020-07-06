package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * E.g.    Input: n = 4, k = 2
 * Output: [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4]
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || k < 0 || k > n) {
            return res;
        }
        List<Integer> comb = new ArrayList<>();
        helper(1, n, k, comb, res);
        return res;
    }

    private void helper(int index, int n, int k, List<Integer> comb, List<List<Integer>> res) {
        if (comb.size() == k) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        if (index > n) {
            return;
        }
        comb.add(index);
        helper(index + 1, n, k, comb, res);
        comb.remove(comb.size() - 1);

        helper(index + 1, n, k, comb, res);
    }
}

/*
*
* 一共有n层，每层代表一个position
每层分2叉，左叉代表加当前position的element， 右叉代表不加。
当我们的pathPrefix里的值满足k个 的时间我们就可以把它加入到我们res里了，并且return。
时间复杂度： 2叉n层， 所有是O(2^n)的时间复杂度。 空间是O(n)的， 因为有n层。
* */
