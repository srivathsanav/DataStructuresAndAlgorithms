package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 30/10/15.
 */
public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode a, int b) {
        if ( b <= 0) {
            return  a;
        }
        int length  = length(a);

        if (b > length) {
            b = length;
        }

        int count = length;

        ListNode current = a;
        ListNode preivous = null;

        while (current != null) {
            ListNode next = current.next;
            if (count == b) {
                if (preivous != null) {
                    preivous.next = next;
                } else {
                    a = next;
                }
                break;
            }  else {
                preivous = current;
                current = next;
            }
            count --;
        }
        return a;
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
        ListNode list = createLinkedList(Arrays.asList(1, 2, 3, 4, 5));

        list = removeNthFromEnd(list, 0);

        print(list);

    }

}
