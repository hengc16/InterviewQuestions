package com.heng.code.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here
        if(input == null || input.length() == 0 || t == null || t.length () == 0){
            return input;
        }
        Set<Character> set = new HashSet<>();
        for(char c : t.toCharArray()) {
            set.add(c);
        }
        char[] array = input.toCharArray();
        int slow = 0; // [0 ... slow ) final res.   [i ... n - 1] not sure
        for(int i = 0; i < array.length; i++) {
            if(!set.contains(array[i])){
                array[slow++] = array[i];
            }
        }
        return new String(array, 0, slow);
    }
}
