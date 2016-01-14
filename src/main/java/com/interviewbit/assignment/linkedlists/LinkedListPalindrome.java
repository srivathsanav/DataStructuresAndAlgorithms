package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 31/10/15.
 */
public class LinkedListPalindrome {

    public static int lPalin(ListNode A) {
        int length = length(A);
        if (length <= 1) {
            return  1;
        }
        ListNode current = A;
        ListNode previous = null;
        int count = 0;
        while (length/2 > count) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++ ;
        }

        if (length %2 != 0) {
            current = current.next;
        }

        while (previous!= null && current != null) {
            if (current.val != previous.val) {
                return 0;
            } else {
                previous = previous.next;
                current = current.next;
            }
        }

       return  1;
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
        ListNode list = createLinkedList(Arrays.asList(1,2,3));
        System.out.println(lPalin(list));


    }
}
