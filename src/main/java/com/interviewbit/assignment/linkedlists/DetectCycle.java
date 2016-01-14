package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = a;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;

        }
        return fast;
    }


    public static void print (ListNode a) {
        while (a != null)  {
            System.out.println(a.val);
            a = a.next;
        }
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


    public static void main(String[] args) {

    }
}
