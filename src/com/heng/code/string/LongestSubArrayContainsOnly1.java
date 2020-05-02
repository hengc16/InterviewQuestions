package com.heng.code.string;

/**
 * Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k 0s to 1s, return the longest subarray that contains only integer 1 after flipping.
 *
 * Assumptions:
 *
 * 1. Length of given array is between [1, 20000].
 *
 * 2. The given array only contains 1s and 0s.
 *
 * 3. 0 <= k <= length of given array.
 *
 * Example 1:
 *
 * Input: array = [1,1,0,0,1,1,1,0,0,0], k = 2
 *
 * Output: 7
 *
 * Explanation: flip 0s at index 2 and 3, then the array becomes [1,1,1,1,1,1,1,0,0,0], so that the length of longest subarray that contains only integer 1 is 7.
 */
public class LongestSubArrayContainsOnly1 {
    public int longestConsecutiveOnes(int[] nums, int k) {
        int slow = 0;
        int fast = 0;
        int count = 0;
        int longest = 0;
        while(fast < nums.length) {
            if(nums[fast] == 1) {
                longest = Math.max(longest, fast++ - slow + 1);
            }else if (count < k) {
                count++;
                longest = Math.max(longest, fast++ - slow + 1);
            }else if(nums[slow++] == 0) { //如果count满了，fast 也不是1了， 只能挪动slow指针，找到第一个0，将其弹出，重新算这个subarray的长度。
                count--;
            }
        }
        return longest;
    }
}
/**
 * 马甲：
 * 其实就是 find the longest substring that contain k zeros.
 */