package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/12/15.
 */
public class ReverseLinkListRecursive {

    public ListNode reverseList(ListNode a) {
       return reverseList(a, null);
    }

    public ListNode reverseList(ListNode n, ListNode prev) { ;
        if(n==null) return null;
        if(n.next==null){ //if this is the end of the list, then this is the new head
            n.next=prev;
            return n;
        }
        ListNode r=reverseList(n.next, n);  //call reverse for the next node,
        //using yourself as the previous node
        n.next=prev;                     //Set your next node to be the previous node
        return r;
    }

    public ListNode reverseList1(ListNode p)
    {
        if (p.next == null || p == null) {
            return p;
        }
        ListNode nextNode = p.next;
        ListNode head = reverseList1(p.next);
        nextNode.next = p;
        p.next = null;

        return head;
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
        ListNode list = createLinkedList(Arrays.asList(1, 2, 3));
        list = new ReverseLinkListRecursive().reverseList1(list);
        print(list);

    }
}
