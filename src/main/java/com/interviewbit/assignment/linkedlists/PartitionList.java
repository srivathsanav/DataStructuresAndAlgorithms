package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class PartitionList {

    public static ListNode partition(ListNode a, int b) {

        if (a == null || a.next == null) {
            return  a;
        }
        ListNode beforeStart = null;
        ListNode beforeEnd = null;

        ListNode afterStart = null;
        ListNode afterEnd = null;
        ListNode node = a;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < b) {
                if (beforeStart == null) {
                    beforeStart = node;
                }
                if (beforeEnd == null) {
                    beforeEnd = node;
                    beforeEnd.next = null;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = beforeEnd.next;
                }

            } else {
                if (afterStart == null) {
                    afterStart = node;
                }
                if (afterEnd == null) {
                    afterEnd = node;
                    afterEnd.next = null;
                } else {
                    afterEnd.next = node;
                    afterEnd = afterEnd.next;
                }
            }
            node = next;
        }
        if (afterEnd != null)
             afterEnd.next = null;
        if ( beforeStart == null) {
            return  afterStart;
        } else {
            beforeEnd.next = afterStart;
        }
        return  beforeStart;
    }

    private static ListNode createLinkedList(List<Integer> numbers) {
        ListNode previousNode = new ListNode(numbers.get(0), null);
        ListNode head = previousNode;
        for (int i =1; i < numbers.size(); i++) {
            ListNode y = new ListNode(numbers.get(i), null);
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
        ListNode list = createLinkedList(Arrays.asList(3,3,3,3,3,3, 10, 17,1, 15));

        list = partition(list, 3);

        print(list);
    }
}
