package com.heng.code.array;

import java.util.*;

/**
 * Find all pairs of elements in a given array that sum to the pair the given target number. Return all the distinct pairs of values.
 * <p>
 * Assumptions
 * <p>
 * The given array is not null and has length of at least 2
 * The order of the values in the pair does not matter
 * Examples
 * <p>
 * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
 */
public class SumOfAllPairs {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            Integer count = map.get(num);
            //case 1, num + num = target,  and it only occur once before.
            if (num * 2 == target && count != null && count == 1) {
                res.add(Arrays.asList(num, num));
            }
            //case 2: num + something == target, and we know num is the first time we seen, and we have the something in map.
            else if (map.containsKey(target - num) && count == null) {
                res.add(Arrays.asList(num, target - num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return res;
    }
}
/*
 找所以能组合成target的 pair，  pair 与pair 之间不能重复。 return a list of pairs（not index）
 如果是sorted 可以用 two pointer
 如果 时间需求 > 空间需求： 用hashmap
 如果 空间需求 > 时间需求： sort it，use two pointer
 如果 array是mutable的， 可以用heapify 来sort， O(n) 时间， O(1) 空间

 HashMap:
 iterate the array, in each iteration :
  before we add a pair to the result: two cases to make sure;
    case1. if 2 * x == target, make sure there is no dup
    case2. if x + y == target, this is the first time both x and y are present, make sure no dup.

*/