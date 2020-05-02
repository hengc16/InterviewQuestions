package com.heng.code.string;

/**
 * Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
 *
 * Assumptions
 *
 * input, S and T are not null, S is not empty string
 * Examples
 *
 * input = "appledogapple", S = "apple", T = "cat", input becomes "catdogcat"
 * input = "laicode", S = "code", T = "offer", input becomes "laioffer"
 */
public class ReplaceString {
    public String replace(String input, String source, String target){
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int match = input.indexOf(source,start);
        while(match!= -1) {
            sb.append(input, start, match).append(target);
            start = match + source.length();
            match = input.indexOf(source,start);
        }
        sb.append(input, start, input.length());
        return sb.toString();
    }
}
/**
 * index of 的时间复杂度是 n * m 的  n 是input 长度  m 是 source 长度
 * 这里我们跑了k次 index of    这里k是source出现的次数
 * 所以时间复杂度是k * n * m， append操作是amortize O（1）的
 * 空间 我们开了个stringbuilder 所以是O(n)的
 */
