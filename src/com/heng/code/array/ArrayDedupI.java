package com.heng.code.array;

import java.util.Arrays;

public class ArrayDedupI {
    public int[] dedupIone(int[] input) {
        if(input == null || input.length == 0) {
            return input;
        }
        int s = 0;
        for (int f = 1; f < input.length; f++) {
            if(input[f] != input[s]) {
                input[++s] = input[f];
            }
        }
        return Arrays.copyOf(input, s + 1);
    }
    public int[] dedupItwo(int[] input) {
        if(input == null || input.length == 0) {
            return input;
        }
        int s = 1;
        for(int f = 1; f < input.length; f++ ) {
            if(input[f] != input[s - 1]) {
                input[s++] = input[f];
            }
        }
        return Arrays.copyOf(input, s);
    }

    public static void main(String[] args) {
        ArrayDedupI test1 = new ArrayDedupI();
        int[] res = test1.dedupIone(new int[]{1,2,2,3,3,3});
        int[] res2 = test1.dedupItwo(new int[]{1,2,3,3,3,3,3});
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
        for(int i = 0; i < res2.length; i++){
            System.out.println(res2[i]);
        }
    }
}
