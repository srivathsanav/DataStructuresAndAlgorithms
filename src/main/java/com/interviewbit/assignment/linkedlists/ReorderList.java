package com.interviewbit.assignment.linkedlists;

import com.interviewbit.assignment.HackerEarthProblems.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 31/10/15.
 */
public class ReorderList {


    /**
     * Created by srivathsan on 31/10/15.
     */

        public static ListNode reorderList(ListNode A) {
            int length = length(A);
            if (length <= 1) {
                return  A;
            }
            ListNode current = A;
            ListNode previous = null;
            int count = 0;

            while (count < length/2) {
                current = current.next;
                count++;
            }

            count = 0;

            if (length %2 != 0) {
                current = current.next;
            }

            while (length/2 > count) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                count++ ;
            }

           ListNode first = A;
            count = 0;
            while (previous!= null && first != null && length/2 > count) {
                ListNode firstNext = first.next;
                ListNode previousNext = previous.next;
                if ( first.next == previous) {
                    first.next.next = null;
                    break;
                } else {
                    first.next = previous;
                }
                previous .next = firstNext;
                first = firstNext;
                previous = previousNext;
                count++;
            }

            if (length %2 != 0) {
                first.next = null;
            }

            return  A;
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
            ListNode list = createLinkedList(Arrays.asList(1, 2,3,4,5,6));
            list = reorderList(null);
            print(list);

        }


}
