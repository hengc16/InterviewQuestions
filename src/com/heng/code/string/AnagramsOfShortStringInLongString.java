package com.heng.code.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find all occurrence of anagrams of a given string s in a given string l. Return the list of starting indices.
 *
 * Assumptions
 *
 * sh is not null or empty.
 * lo is not null.
 * Examples
 *
 * l = "abcbac", s = "ab", return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
 */
public class AnagramsOfShortStringInLongString {
    public List<Integer> allAnagrams(String sh, String lo) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if(lo.length() == 0 || sh.length() > lo.length()) {
            return res;
        }
        //<字母in sh, 字母出现次数>
        Map<Character, Integer> map = countMap(sh);
        int match = 0; // count for so far the match character
        for(int i = 0; i < lo.length(); i++) {
            char tmp = lo.charAt(i);
            Integer count = map.get(tmp);
            // 如果出现过，判断是否减完就空了， 我们就找到了一个match，  负责直接减减
            if(count != null) {

                if(count == 1) {
                    match++;
                }
                map.put(tmp, count - 1);
            }
            // 如果没出现过，并且当前值大于等于s的长度， 我们需要看当前subarray的头element， 因为subarray的长度是fix，我们可以access头element by using i - sh.length()
            //如果头element 出现过， 但是count为空，表示这个char的次数我们在之前已经match完了，所以不match， match--。 并且把这个char出现的次数 + 1.
            //
            if(i >= sh.length()) {
                tmp = lo.charAt(i - sh.length());
                count = map.get(tmp);
                if(count != null) {

                    if(count == 0) {
                        match--;
                    }
                    map.put(tmp, count + 1);
                }
            }
            // match perfectly, add the left index of the subarray to the final res.
            if(match == map.size()) {
                res.add(i - sh.length() + 1);
            }
        }
        return res;

    }
    private Map<Character, Integer> countMap(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) {
                map.put(c, 1);
            }else{
                map.put(c, count + 1);
            }
        }
        return map;
    }
}
/*
用一个map 存s里的字母 <字母，出现次数>  用sliding window 去找subarray that 可以完美抵消map里的字母次数，我们就记录这个subarray的start index。
*/


