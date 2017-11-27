package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class SwapList {

    public static ListNode swapPairs(ListNode a) {
        ListNode rootnode = new ListNode(0, null);
        rootnode.next = a;

        ListNode temp = rootnode;
        while (temp.next != null && temp.next.next != null) {
            temp.next = swapNodes(temp.next, temp.next.next);
            temp = temp.next.next;

        }
        return rootnode.next;
    }

    private static ListNode swapNodes (ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        return  node2;
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
        ListNode list = createLinkedList(Arrays.asList(1, 2, 3, 4, 5, 6));
        list = swapPairs(list);
        print(list);

    }

}
