package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 30/10/15.
 */
public class RotateTheList {

    public static ListNode rotateRight(ListNode a, int b) {
        if ( b <= 0) {
            return  a;
        }
        int length = length(a);
        if ( b > length) {
            b = b % length;
        }
        if ( b == length || b <= 0) {
            return a;
        }
        int forward = length - b;
        ListNode head = a;
        while (forward > 1) {
            head = head.next;
            forward--;
        }

        ListNode rotated = head.next;
        head.next = null;

        head = rotated;

        while (head.next != null) {
            head =  head.next;
        }
        head.next = a;
        a= rotated;
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
        ListNode list = createLinkedList(Arrays.asList(91,34,18,83,38,82));

        list = rotateRight(list, 90);

        print(list);

    }



}
