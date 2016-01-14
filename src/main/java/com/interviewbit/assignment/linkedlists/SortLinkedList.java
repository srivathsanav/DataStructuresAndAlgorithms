package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class SortLinkedList {




    public static ListNode sortList(ListNode a) {
        if (a == null || a.next == null) {
            return a;
        }
        ListNode p=a ,q=a;
        while(p.next!= null && p.next.next!= null){
            p=p.next.next;
            q=q.next;
        }
        p=q;
        q=q.next;
        p.next=null;
        p=sortList(a);
        q=sortList(q);
        return merge(p,q);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        }
        if ( right != null) {
            current.next = right;
        }
        return dummy.next;
    }

    private static ListNode createLinkedList(List<Integer> numbers) {
        ListNode previousNode = new ListNode(numbers.get(0));
        ListNode head = previousNode;
        for (int i =1; i < numbers.size(); i++) {
            ListNode y = new ListNode(numbers.get(i));
            previousNode.next = y;
            previousNode = y;
        }
        return head;
    }

    private static int length(ListNode a) {
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        return length;
    }

    public static void print (ListNode a) {
        while (a != null)  {
            System.out.println(a.val);
            a = a.next;
        }
    }

    public static void main(String[] args) {
        ListNode list = createLinkedList(Arrays.asList(4,3,2,1));

        list = sortList(list);

        print(list);

    }

}
