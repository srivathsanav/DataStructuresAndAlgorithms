package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 30/10/15.
 */
public class DeleteDupllicatesLinkedList {


    public static ListNode deleteDuplicates1(ListNode a) {

        ListNode head = a;
        while ( head != null) {
            int currentVal = head.val;
            ListNode next = head.next;
            if (next != null) {
                if (currentVal == next.val) {
                    head.next = next.next;
                } else {
                    head = head.next;
                }
            } else {
                break;
            }
        }


        return  a;
    }


    public static ListNode deleteDuplicates(ListNode a) {

        if (a == null || a.next == null) {
            return a;
        }

        ListNode temp = a;
        while ( temp.next != null) {
            int nextVal = temp.val;
            if (nextVal == temp.next.val) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                }
            } else {
                temp = temp.next;
            }
        }


        return  a;
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
        for (int i =0; i < numbers.size(); i++) {
            ListNode y = new ListNode(numbers.get(i));
            previousNode.next = y;
            previousNode = y;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = createLinkedList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4));

        //print(list);

        list = deleteDuplicates1(list);
       print(list);
    }
}
