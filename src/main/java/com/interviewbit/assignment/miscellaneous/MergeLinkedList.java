package com.interviewbit.assignment.miscellaneous;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

/**
 * Created by avsrivathsan on 6/9/2017.
 */
public class MergeLinkedList {

    public ListNode mergeLinkedList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode current = dummyHead;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            dummyHead = dummyHead.next;
        }
        current.next = p1 == null ? p2  :p1;
        return dummyHead.next;
    }
}
