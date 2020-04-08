package com.heng.code.stackqueue;
/**
 * Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
 *
 * After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
 *
 * There can be duplicated numbers in the give stack.
 */

import java.util.LinkedList;

public class SortWithTwoStacks {
    private void sortWithTwoStack(LinkedList<Integer> stack1) {
        if (stack1 == null || stack1.size() == 0) {
            return;
        }
        LinkedList<Integer> stack2 = new LinkedList<>();
        sort(stack1, stack2);
    }

    /**
     *
     * @param input  an unsorted stack
     * @param buffer  top part of this stack is buffer section, bottom part is sorted elements.
     */
    private void sort(LinkedList<Integer> input, LinkedList<Integer> buffer) {
        while(!input.isEmpty()) {
            int count = 0;
            int min = Integer.MAX_VALUE;
            while(!input.isEmpty()){  // move the element to the buffer stack, find the cur min
                int top = input.pop();
                if( top < min) {
                    min = top;
                    count = 1;
                }else if (top == min) {
                    count ++;
                }
                buffer.push(top);
            }
            while(!buffer.isEmpty() && buffer.peek() >= min) {  //pop all the element except prev sorted element.
                int tmp = buffer.pop();
                if(tmp != min) {
                    input.push(tmp);
                }
            }
            while(count > 0) {       // add all the cur min to the buffer.
                buffer.push(min);
                count--;
            }
        }

        while(!buffer.isEmpty()) {   //move the sorted stack to input, so its in ascending order
            input.push(buffer.pop());
        }

    }


    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(2);
        stack.push(11);
        stack.push(1);
        stack.push(6);
        stack.push(4);
        System.out.println(stack.toString());
        SortWithTwoStacks test1 = new SortWithTwoStacks();
        test1.sortWithTwoStack(stack);
        System.out.println(stack.toString());
    }
}
