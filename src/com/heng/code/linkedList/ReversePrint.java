package com.heng.code.linkedList;

public class ReversePrint {
    public void reversePrint(ListNode head){
        if(head == null) return;
        reversePrint(head.next);
        System.out.println(head.value);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        ReversePrint test1 = new ReversePrint();
        test1.reversePrint(head);
    }
}
