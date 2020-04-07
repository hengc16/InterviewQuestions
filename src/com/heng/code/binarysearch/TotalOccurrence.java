package com.heng.code.binarysearch;

/**
 * Description
 * Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.
 * <p>
 * <p>
 * Example
 * Given [1, 3, 3, 4, 5] and target = 3, return 2.
 * <p>
 * Given [2, 2, 3, 4, 6] and target = 4, return 1.
 * <p>
 * Given [1, 2, 3, 4, 5] and target = 6, return 0.
 */
public class TotalOccurrence {
    /**
     * @param input  An Integer array sorted in amending order
     * @param target An Integer target
     * @return return An Integer of number of target.
     */
    private int totalOccurrence(int[] input, int target) {
        int res = 0;
        //corner case checking
        if (input == null || input.length == 0) {
            return res;
        }
        int left = firstOccur(input, target);
        int right = lastOccur(input, target);
        if (left != -1 && right != -1) {
            return right - left + 1;
        }
        return res;
    }

    /**
     * @param array  An Integer array sorted in ascending order
     * @param target An given Integer
     * @return return the first occur target's index if exist, otherwise -1;
     */
    private int firstOccur(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) { //more than 3 element to do the comparision
            int mid = left + (right - left) / 2; //avoid overflow
            if (array[mid] >= target) {   //mid is greater or equal to target, the mid might or might not be the
                // first target, but the elements on the right hand side of mid are 100% not the first occur of target
                right = mid;
            } else {
                left = mid;
            }
        }
        //post-processing: compare the last two elements to target
        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        }
        return -1;
    }

    /**
     * @param array  An Integer array sorted in ascending order
     * @param target An given Integer
     * @return return the last occur target's index if exist, otherwise -1;
     */
    private int lastOccur(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) { //more than 3 element to do the comparision
            int mid = left + (right - left) / 2; //avoid overflow
            if (array[mid] <= target) {   //mid is less or equal to target, the mid might or might not be the
                // last target, but the elements on the left hand side of mid are 100% not the last occur of target
                left = mid;
            } else {
                right = mid;
            }
        }
        //post-processing: compare the last two elements to target
        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 2, 2, 2, 3, 3, 4, 5, 5};
        int target = 2;
        TotalOccurrence test1 = new TotalOccurrence();
        int res = test1.totalOccurrence(input, target);
        System.out.println(res); // output 5
    }
}
