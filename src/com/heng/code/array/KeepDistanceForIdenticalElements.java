package com.heng.code.array;

/**
 * Given an integer k, arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], such that the output integer array satisfy this condition:
 *
 * Between each two i's, they are exactly i integers (for example: between the two 1s, there is one number, between the two 2's there are two numbers).
 *
 * If there does not exist such sequence, return null.
 *
 * Assumptions:
 *
 * k is guaranteed to be > 0
 * Examples:
 *
 * k = 3, The output = { 2, 3, 1, 2, 1, 3 }.
 */
public class KeepDistanceForIdenticalElements {
    public int[] keepDistance(int k) {
        // Write your solution here.
        int[] array = new int[2 * k];
        return helper(array, k) ? array : null;
    }
    private boolean helper(int[] array, int n) {
        if(n == 0) {
            return true;
        }
        for(int i = 0; i < array.length - 1 - n; i++) {     //0 到最后一个数- 当前值得位置
            if(array[i] == 0 && array[i + n + 1] == 0) {    //如果左边的坑这个坑没被占 并且右边的坑也没被占  左右之间要隔n位
                array[i] = n;                               //占左坑，
                array[i + n + 1] = n;                      // 占右坑
                if(helper(array, n - 1)) {              //去考虑下一层
                    return true;
                }
                array[i] = 0;                              // 吐出来
                array[i + n + 1] = 0;                      // 吐出来
            }
        }
        return false;
    }
}
/*
*                       332211
*                    /               \
*                3_ _ _ 3_            _3_ _ _ 3
*              /       \              /
         32_23_    3_ 2 _32     23_2_3
            |         |          |
         321231    312132       231213
 * /
 */