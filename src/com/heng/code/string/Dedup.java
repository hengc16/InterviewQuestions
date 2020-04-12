package com.heng.code.string;

/**
 * Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
 * <p>
 * Examples
 * <p>
 * “aaaabbbc” is transferred to “abc”
 */
public class Dedup {
    public String deDup(String input) {
        // Write your solution here
        if (input == null || input.length() <= 0) {
            return input;
        }
        int index = 0;
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] != array[index - 1]) {
                array[index++] = array[i];
            }
        }
        return new String(array, 0, index);
    }
}
