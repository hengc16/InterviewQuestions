package com.heng.code.stackqueue;

import java.util.LinkedList;

public class SortWithThreeStack {
    private void sortWithThreeStack(LinkedList<Integer> stack1) {
        if (stack1 == null || stack1.size() == 0) {
            return;
        }
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();
        sort(stack1, stack2, stack3);
    }

    private void sort(LinkedList<Integer> input, LinkedList<Integer> buffer, LinkedList<Integer> result) {
        int size = input.size();
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE;
            while (!input.isEmpty()) {
                int top = input.pop();
                min = Math.min(min, top);
                buffer.push(top);
            }
            result.push(min);
            while (!buffer.isEmpty()) {
                int top = buffer.pop();
                if (top == min) {
                    continue;
                }
                input.push(top);
            }
        }
        while (!result.isEmpty()) {
            input.push(result.pop());
        }

    }


    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(2);
        stack.push(11);
        stack.push(1);
        stack.push(6);
        stack.push(4);
        SortWithThreeStack test1 = new SortWithThreeStack();
        test1.sortWithThreeStack(stack);
        System.out.println(stack.toString());
    }
}

//s1
//s2 6 2 3 4          min 1
//s3