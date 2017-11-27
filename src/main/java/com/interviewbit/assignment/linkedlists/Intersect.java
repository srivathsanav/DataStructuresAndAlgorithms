package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

/**
 * Created by srivathsan on 30/10/15.
 */
public class Intersect {

    public static ListNode getIntersectionNode(ListNode a, ListNode b) {
        int lengthA = length(a) ;
        int lengthB = length(b);
        int differenece =0;
        if (lengthA > lengthB) {
            ListNode temp = a;
            a = b;
            b = temp;
            differenece = lengthA - lengthB;
        } else {
            differenece = lengthB - lengthA;
        }

        for (int i =0; i < differenece; i++) {
            b = b.next;
        }


        for (int i =0; i < lengthA; i++) {
                if (a == b) {
                    return  a;
                } else {
                    a = a.next;
                    b = b.next;
                }

        }
        return  null;
    }

    private static int length(ListNode a) {
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode a  =  new ListNode(1, null);
        ListNode merge = new ListNode(5, null);
        merge.next = new ListNode(2, null);
        merge.next.next = new ListNode(3, null);
        merge.next.next.next = null;
        ListNode b = merge;
        a.next = merge;

        System.out.println(getIntersectionNode(a, b).val);
    }
}
