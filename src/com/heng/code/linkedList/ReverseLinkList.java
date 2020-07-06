package com.heng.code.linkedList;

public class ReverseLinkList {
    public ListNode reverseLinkList(ListNode head){
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    public ListNode reverseRecursive(ListNode head){
        if(head == null) {
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode last = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    public void print (ListNode head){
        while(head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ReverseLinkList test1 = new ReverseLinkList();

        //ListNode reversedNode = test1.reverseLinkList(head);
        ListNode reversedNode = test1.reverseRecursive(head);
        test1.print(reversedNode);
    }
}
