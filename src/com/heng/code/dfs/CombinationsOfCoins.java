package com.heng.code.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.
 * <p>
 * Arguments
 * <p>
 * coins - an array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
 * target - a non-negative integer representing the target number of cents, eg. 99
 * Assumptions
 * <p>
 * coins is not null and is not empty, all the numbers in coins are positive
 * target >= 0
 * You have infinite number of coins for each of the denominations, you can pick any number of the coins.
 * Return
 * <p>
 * a list of ways of combinations of coins to sum up to be target.
 * each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
 */
public class CombinationsOfCoins {
    public List<List<Integer>> combinations(int target, int[] coins) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        helper(target, coins, 0, cur, result);
        return result;
    }

    public void helper(int target, int[] coins, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == coins.length - 1) {
            if (target % coins[coins.length - 1] == 0) {
                cur.add(target / coins[coins.length - 1]);
                result.add(new ArrayList<Integer>(cur));
                cur.remove(cur.size() - 1);
            }
            return;
        }
        int max = target / coins[index];
        for (int i = 0; i <= max; i++) {
            cur.add(i);
            helper(target - i * coins[index], coins, index + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
  /*
                         []
                     /  |   |  \
  index(0)25 cents         []   []   [] []        第一层是加一个25censt  到 加 target/25 个25cents
                /||||||||\
  index(1)10 cents     []][][][].......             第2层是加1个10cents 到 target - 上一层的25cents*它的个数（moneyleft）/ 10
               /||||||||||||||....\
  index(2)5 cents   [][][][][][][].....
            /||||||||||||||||||||||||||||......\
  index(3)1 cents [][][][][][][][][][]...........





  */
}