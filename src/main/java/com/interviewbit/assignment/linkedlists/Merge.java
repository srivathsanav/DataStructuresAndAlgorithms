package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 30/10/15.
 */
public class Merge {

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode merged = null;

        if ( b == null) {
            return a;
        } else if (a == null) {
            return b;
        }
        ListNode head = null;

        while (a !=null && b != null) {
            List<ListNode> result = null;
            if (a.val <= b.val) {
                result = insertNode(merged, head, a.val);
                a = a.next;
            }  else {
                result  = insertNode(merged, head,  b.val);
                b = b.next;
            }
            merged = result.get(0);
            head = result.get(1);
        }

        if (a != null) {
            insertNode(merged, a);
        } else if (b != null){
            insertNode(merged, b);
        } else if (a == null && b == null) {
            insertNode(merged, null);
        }
        return  merged;
    }

    private static void insertNode (ListNode merged, ListNode a) {

       while (merged.next != null) {
           merged = merged.next;
       }
        merged.next = a;
    }
    private static List<ListNode> insertNode (ListNode merged, ListNode head, int val ) {

        if (head == null) {
            head = new ListNode(val, null);
            head.next = null;

        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = new ListNode(val, null);
        }
        merged = merged == null ? head : merged;
        List<ListNode> result = new ArrayList<ListNode>();
        result.add(merged);
        result.add(head);
        return  result;
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
        ListNode list1 = createLinkedList(Arrays.asList(1, 3, 5, 7, 9));
        ListNode list2 = createLinkedList(Arrays.asList(6,8,40));
        ListNode list3 = mergeTwoLists(list1, list2);


        print(list3);

    }


}
