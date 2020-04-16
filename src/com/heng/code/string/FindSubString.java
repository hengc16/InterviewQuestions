package com.heng.code.string;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

public class FindSubString {
    public List<Integer> finaAllSubString(String input, String target) {
        char[] array = input.toCharArray();
        char[] sub = target.toCharArray();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= array.length - sub.length; i++) {
            if(ifMatch(array, sub, i)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean ifMatch(char[] array, char[] sub, int start) {

        for(int i = 0; i < sub.length; i++){
            if(array[i + start] != sub[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String test1 = new String("abaacababcacababc");
        String target1 = new String("ababc");
        FindSubString findSubString = new FindSubString();
        List<Integer> test= new ArrayList<>();
        test = findSubString.finaAllSubString(test1, target1);
        System.out.println(test.toString());
    }
}
