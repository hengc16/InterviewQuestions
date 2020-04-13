package com.heng.code.string;

/**
 * Reverse the words in a sentence.
 *
 * Assumptions
 *
 * Words are separated by single space
 *
 * There are no heading or tailing white spaces
 *
 * Examples
 *
 * “I love Google” → “Google love I”
 */
public class ReverseSentence {
    public String reverseWords(String input) {
        // Write your solution here
        //思路： 通过空格把句子分成单词
        // 先把input变成char array， 然后反转
        // i love google  反转成 elgoog evol i
        // 通过找空格 在反转每个word  来实现 google love i
        char[] array = input.toCharArray();
        reverse( array, 0, array.length - 1);
        int beginIndex = 0;
        for(int i = 0; i < array.length; i++){
            //找begin index
            if(array[i] != ' '&& (i == 0 || array[i - 1] == ' ')){
                beginIndex = i;
            }
            if(array[i] != ' ' && ( i == array.length - 1 || array[i + 1] == ' ')){
                reverse(array, beginIndex, i);
            }
        }
        return new String(array);
    }
    private void reverse (char[] array, int left, int right){
        while(left < right){
            char temp = array[left];
            array[left++] = array[right];
            array[right--] = temp;
        }
    }
}
