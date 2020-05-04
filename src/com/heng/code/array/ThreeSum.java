package com.heng.code.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Determine if there exists three elements in a given array that sum to the given target number. Return all the triple of values that sums to target.
 *
 * Assumptions
 *
 * The given array is not null and has length of at least 3
 * No duplicate triples should be returned, order of the values in the tuple does not matter
 * Examples
 *
 * A = {1, 2, 2, 3, 2, 4}, target = 8, return [[1, 3, 4], [2, 2, 4]]
 */
public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for(int i = 0; i < array.length - 2; i++) {
            // if we have 1, 1, 1,  the first 1 will be selected.
            if(i > 0 && array[i] == array[i -1]){
                continue;
            }
            int left = i + 1;
            int right = array.length -1;
            while(left < right) {
                int tmp = array[left] + array[right];
                if(tmp + array[i] == target) {
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while(left < right && array[left] == array[left - 1]){
                        left++;
                    }
                }else if (tmp + array[i] < target) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
/*
* Assume:
* 1. no duplication.
* 2. optimize for time
* 3. data size is small enough to fit in memory
* 4. unsorted.
*
* 可以用2sum 外面套个for 循环，  时间复杂度是n^2  空间是O(n)
* 也可以先sort array， 再iterate每一个element cur， 找 A[cur] + A[b] + A[c] == target  所以是一个N^2的时间复杂度。
*
* */