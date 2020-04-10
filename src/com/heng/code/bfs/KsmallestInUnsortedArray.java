package com.heng.code.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
 *
 * Assumptions
 *
 * A is not null
 * K is >= 0 and smaller than or equal to size of A
 * Return
 *
 * an array with size K containing the K smallest numbers in ascending order
 * Examples
 *
 * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
 */
public class KsmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        // Write your solution here
        // max heap   only keep the 7 smallest number,  we compare the new number with the top value, replace the top value
        // if the new one is smaller than the top value. 如果比top大， 说明比7个小矮人都高。
        // 所以用max heap 可以解决 第k小 和前k小这2个题
        if(array == null || array.length == 0 || k == 0){
            return new int[0];
        }
        //covert pq to maxheap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                if(o1.equals(o2)){
                    return 0;
                }
                return o1 > o2 ? -1: 1;
            }
        });
        for(int i = 0; i < array.length; i++){
            if(i < k){
                maxHeap.offer(array[i]);
            }else if(array[i] < maxHeap.peek()){ // 找到新的小矮人了
                maxHeap.poll();  // 扔掉最高的小矮人
                maxHeap.offer(array[i]); // 换上新来的小矮人
            }
        }
        //把的出来的k个小矮人倒着装箱 return；
        int [] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = maxHeap.poll();
        }
        return res;
    }
}

