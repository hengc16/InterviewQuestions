package com.heng.code.string;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
 *
 * Assumptions
 *
 * The string is not null
 *
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 *
 * Examples
 *
 * “abbcccdeee” → “a1b2c3d1e3”
 */

public class CompressString {

    public String compress(String input) {
        // Write your solution here
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        return enCode(array);
    }

    private String enCode(char[] array) {
        //case1: adjacent occurance of letters >= 2
        int s = 0;
        int f = 0;
        int newLength = 0;
        while (f < array.length) {
            int begin = f;
            while (f < array.length && array[f] == array[begin]) {
                f++;
            }
            array[s++] = array[begin];
            //== 2个letter
            if (f - begin == 1) {
                newLength += 2;
            } else {
                int len = copyDigits(array, s, f - begin);
                s += len;
                newLength += len + 1;
            }
        }
        //case2: adjacent occurrence of the letters == 1
        //我们知道了最后return值得长度，重塑res array
        char[] res = new char[newLength];
        f = s - 1; //
        s = newLength - 1; //从res 尾部往左加入
        while (f >= 0) {
            if (Character.isDigit(array[f])) {
                //如果是数字 就加入s区间
                while (f >= 0 && Character.isDigit(array[f])) {
                    res[s--] = array[f--];
                }
            } else {
                //如果是letter，
                res[s--] = '1';
            }
            res[s--] = array[f--];
        }
        return new String(res);
    }

    //取一组subarray start at index， count是subarray的长度， 返回letter后最后的长度。 如bbbbb => b5 返回1
    private int copyDigits(char[] input, int index, int count) {
        int len = 0;
        for (int i = count; i > 0; i /= 10) {
            index++;
            len++;
        }
        for (int i = count; i > 0; i /= 10) {
            //当前层 取个位数，替代当前letter
            int digit = i % 10;
            input[--index] = (char) ('0' + digit);
        }
        return len;
    }

}
/**
 * s : the letters to the left of s not including s are the processed letter that should be kept
 * f : the character being processed so far
 * <p>
 * initialization: s = f = 0
 * for each step:
 * f_begin = f
 * keep moving f until a[f] != a[f_begin]
 * compress a[f_begint to f]
 * a[s] = a[f_begin], s++
 * copy f to f_begin as a string to a[s]
 * <p>
 * step1 : same as above, ignore all single characters
 * step2: handle all the single characters
 */
