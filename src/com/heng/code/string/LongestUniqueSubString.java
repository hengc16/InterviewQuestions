package com.heng.code.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Description
 *  Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestUniqueSubString {
    public int longest(String input) {
        // Write your solution here
        if(input == null || input.length() == 0) {
            return 0;
        }
        char[] array = input.toCharArray();
        Map<Character, Integer> map = new HashMap<>();//key is the element, value is the index
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < array.length) {
            if(!map.containsKey(array[right])){
                map.put(array[right++], right);
                max = Math.max(max, right - left + 1);
            }else{
                left = map.get(array[right]) + 1;
            }
        }
        return max;
    }
}
