package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class InsertionSortList {

    static ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode sorted = null;
        ListNode list = head;
        while(list != null) {
            ListNode curr = list;
            list = list.next;
            if(sorted == null || sorted.val > curr.val) {
                // first lookup
                curr.next = sorted; //this indicates the end of sorted list
                sorted = curr;
            } else {
                // insert somewhere after the fisrt of sorted
                ListNode tmp = sorted;
                while (tmp != null)  {
                    ListNode s = tmp;
                    tmp = tmp.next;

                    if (s.next == null || s.next.val > curr.val) {
                        s.next = curr;
                        curr.next = tmp;
                        break;
                    }
                }
            }
        }
        return sorted;
    }

    public static ListNode insertionSortList1(ListNode a) {
        if (a == null || a.next == null) {
            return  a;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = a;
        ListNode firstLoop = a;

        int count = 0;
        while (firstLoop != null) {
            ListNode secondLoop = firstLoop.next;
            while (secondLoop != null) {
                if (firstLoop.val > secondLoop.val) {
                    ListNode temp = secondLoop.next;
                    if (count == 0) {
                        dummy .next = secondLoop;
                    }
                    secondLoop.next = firstLoop;
                    firstLoop.next = temp;
                }
                secondLoop = secondLoop.next;
            }
            firstLoop = firstLoop.next;
            count++;
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
        ListNode list = createLinkedList(Arrays.asList(4, 3, 2, 1,10));

        list = insertionSortList(list);

        print(list);
    }
}
