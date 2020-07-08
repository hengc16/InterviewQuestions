package com.heng.code.linkedList;

public class KthNodeFromTail {
    public ListNode getKthFromTail(ListNode head, int k){
        if(head == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            if(k > 0) {
                fast = fast.next;
                k--;
            }else{
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        KthNodeFromTail test1 = new KthNodeFromTail();
        ListNode res = test1.getKthFromTail(head, 3);
        System.out.println(res.value);
    }
}

/*
*           1-> 2 -> 3 -> 4 -> 5 -> 6 ->null   k = 3
*                         s
*                                       f
*
*
* */