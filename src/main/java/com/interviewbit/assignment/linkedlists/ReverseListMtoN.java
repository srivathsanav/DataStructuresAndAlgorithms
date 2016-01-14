package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 31/10/15.
 */
public class ReverseListMtoN {
    public static ListNode reverseBetween(ListNode a, int m, int n) {
        if ( m == n) {
            return  a;
        }
        int length = length(a);
        if (length <= 1) {
            return  a;
        }
        ListNode current = a;
        int count = 1;

        ListNode before = null;
        while (count < m) {
            before = current;
            current = current.next;
            count++;
        }


        ListNode previous = null;

        ListNode last = current;
        count = 0;
        while ((n -m +1) > count) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++ ;
        }

        last.next = current;
        if (m == 1) {
            a = previous;
        } else {
            before.next = previous;
            before = before.next;
        }




       return a;
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
        ListNode list = createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17 , 18 , 19, 20));
        list = reverseBetween(list, 3, 20);
        print(list);

    }

}
