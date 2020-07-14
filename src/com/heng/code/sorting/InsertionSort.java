package com.heng.code.sorting;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] input){
        for(int i = 1; i < input.length;i++){
            int insertValue = input[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertValue < input[insertIndex]){
                input[insertIndex + 1] = input[insertIndex];
                insertIndex--;
            }
            input[insertIndex + 1] = insertValue;
        }
    }
    public static void main(String[] args) {
        InsertionSort test1 = new InsertionSort();
        int[] sample = new int[]{4,2,11,3,8,-1};
        test1.sort(sample);
        System.out.println(Arrays.toString(sample));
    }
}
