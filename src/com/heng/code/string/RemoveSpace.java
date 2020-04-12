package com.heng.code.string;

/**
 * Given a string, remove all leading/trailing/duplicated empty spaces.
 * <p>
 * Assumptions:
 * <p>
 * The given string is not null.
 * Examples:
 * <p>
 * “  a” --> “a”
 * “   I     love MTV ” --> “I love MTV”
 */
public class RemoveSpace {
    public String removeSpaces(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < array.length; fast++) {
            if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')) {
                continue;
            }
            array[slow++] = array[fast];
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            return new String(array, 0, slow - 1);
        } else {
            return new String(array, 0, slow);
        }
    }
}
