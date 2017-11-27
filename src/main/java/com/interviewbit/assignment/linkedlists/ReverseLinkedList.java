package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

/**
 * Created by srivathsan on 30/10/15.
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode a) {
        ListNode current = a;
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        a = prev;
        return a;
    }

    public static void print (ListNode a) {
        while (a != null)  {
            System.out.println(a.val);
             a = a.next;
        }
    }

    public static void main(String[] args) {
        ListNode merge = new ListNode(5, null);
        merge.next = new ListNode(2, null);
        merge.next.next = new ListNode(3, null);
        merge.next.next.next = null;

        merge = reverseList(merge);
        print(merge);
    }
}
