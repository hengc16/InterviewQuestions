package com.heng.code.sorting;

import java.util.Arrays;

public class ShellSort {
    public void sort(int[] array){
        //最外层
        for(int  gap = array.length / 2; gap > 0;  gap /= 2){
            for(int i = gap; i < array.length; i++){
                int j = i;
                int temp = array[j];
                if(array[j] < array[j-gap]){
                    while(j - gap >= 0 && temp < array[j - gap]) {
                        array[j] = array[j - gap];
                        j-= gap;
                    }
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ShellSort test1 = new ShellSort();
        int[] sample = new int[]{4,2,11,3,8,-1};
        test1.sort(sample);
        System.out.println(Arrays.toString(sample));
    }
}
