package com.heng.code.sorting;

import java.util.Arrays;

public class MergeSortDemo {
    public void mergeSort(int[] array){
        if(array == null) return;
        int[] helper = new int[array.length];
        sort(array, helper, 0, array.length - 1);
    }
    private void sort(int[] array, int[] helper, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        sort(array, helper, left, mid);
        sort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }
    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        for(int i = left; i <= right; i++){
            helper[i] = array[i];
        }
        int l = left;  // [left, mid]
        int r = mid + 1; //[mid+1, right]
        while(l <= mid && r <= right) {
            if(helper[l] <= helper[r]){
                array[left++] = helper[l++];
            }else{
                array[left++] = helper[r++];
            }
        }
        while(l <= mid){
            array[left++] = helper[l++];
        }
    }
    public static void main(String[] args) {
        MergeSortDemo test1 = new MergeSortDemo();
        int[] sample = new int[]{4,2,2,2,2,11,3,2,8,-1};
        test1.mergeSort(sample);
        System.out.println(Arrays.toString(sample));
    }
}
