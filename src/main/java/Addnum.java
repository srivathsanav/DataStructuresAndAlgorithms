package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 01/11/15.
 */
public class Addnum {
    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
       int aLength = length(a);
       int bLength = length(b);
       if ( aLength < bLength) {
           appendZerosAtEnd(a, bLength - aLength);
       } else if ( bLength < aLength){
           appendZerosAtEnd(b, aLength - bLength);
       }
        return sum(a,b, aLength > bLength ? aLength : bLength);

    }

    private static ListNode sum(ListNode a, ListNode b, int length) {
        ListNode result = null;
        ListNode head = null;
        int carry = 0;
        int count = 0;
        while (a != null && b != null) {
            int value1 = a.val;
            int value2 = b.val;
            int value3 = a.val + b.val + carry;

            if ( (value3 / 10) > 0) {
                if (count != length -1) {
                    value3 = value3 % 10;
                    carry = 1;
                } else {
                    head.next = new ListNode(value3% 10);
                    head.next.next = new ListNode(value3/10);
                    head.next.next.next = null;
                    return result;
                }
            } else {
                carry = 0;
            }
            if (head == null) {
                result = new ListNode(value3);
                head = result;
            } else {
                head.next = new ListNode(value3);
                head = head.next;
            }
            head.next = null;
            a = a.next;
            b = b.next;
            count++;
        }
        return result;
    }


    private static ListNode appendZerosAtEnd ( ListNode a, int howMany) {
        while (a != null && a.next != null) {
            a = a.next;
        }
        while (howMany > 0) {
            ListNode zero = new ListNode(0);
            a.next = zero;
            a = a.next;
            howMany--;
        }
        return  a;
    }




    private static int length(ListNode a) {
        int length = 0;
        while (a != null) {
            a = a.next;
            length++;
        }
        return length;
    }
    private static ListNode createLinkedList(String[] numbers) {
        ListNode previousNode = new ListNode(Integer.valueOf(numbers[0]));
        ListNode head = previousNode;
        for (int i =1; i < numbers.length; i++) {
            ListNode y = new ListNode(Integer.valueOf(numbers[i]));
            previousNode.next = y;
            previousNode = y;
        }
        return head;
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

        String s = "9 -> 6 -> 9 -> 4 -> 7 -> 7 -> 8 -> 9 -> 6 -> 4 -> 7 -> 7 -> 4 -> 8 -> 5 -> 1 -> 6 -> 7 -> 7 -> 9 -> 7 -> 4 -> 1 -> 1 -> 4 -> 8 -> 7 -> 8 -> 2 -> 3 -> 5 -> 9 -> 2 -> 8 -> 2 -> 5 -> 8 -> 8 -> 1 -> 9 -> 8 -> 3 -> 4 -> 3 -> 9 -> 6 -> 5 -> 3 -> 4 -> 2 -> 9 -> 9 -> 4 -> 4 -> 3 -> 9 -> 3 -> 1 -> 3 -> 8 -> 1 -> 7 -> 2 -> 5 -> 5 -> 1 -> 3 -> 8 -> 5 -> 6 -> 8 -> 3 -> 2 -> 7 -> 4 -> 2 -> 6 -> 2 -> 3 -> 1 -> 3 -> 7 -> 8 -> 5 -> 9 -> 3 -> 4 -> 8 -> 3 -> 6 -> 5 -> 7 -> 9 -> 4 -> 5 -> 2 -> 6 -> 3 -> 6 -> 2 -> 6 -> 3 -> 5 -> 5 -> 4 -> 5 -> 2 -> 1 -> 5 -> 3 -> 4 -> 5 -> 7 -> 5 -> 9 -> 7 -> 7 -> 7 -> 7 -> 2 -> 2 -> 4 -> 4 -> 7 -> 3 -> 2 -> 4 -> 9 -> 1 -> 7 -> 9 -> 3 -> 4 -> 6 -> 5 -> 7 -> 9 -> 8 -> 7 -> 4 -> 1 -> 7 -> 3 -> 4 -> 7 -> 1 -> 3 -> 6 -> 4 -> 2 -> 7 -> 5 -> 4 -> 7 -> 2 -> 7 -> 6 -> 5 -> 8 -> 5 -> 3 -> 4 -> 7 -> 8 -> 6 -> 4 -> 7 -> 7 -> 9 -> 5 -> 7 -> 4 -> 1 -> 8 -> 8 -> 3 -> 9 -> 3 -> 6 -> 9 -> 8 -> 7 -> 4 -> 9 -> 9 -> 1 -> 4 -> 7 -> 4 -> 6 -> 5 -> 3 -> 2 -> 5 -> 4 -> 4 -> 1 -> 8 -> 3 -> 7 -> 2 -> 7 -> 8 -> 8 -> 6 -> 1 -> 6 -> 3 -> 7 -> 5 -> 4 -> 2 -> 1 -> 8 -> 9 -> 1 -> 9 -> 8 -> 1 -> 7 -> 5 -> 4 -> 7 -> 6 -> 2 -> 6 -> 6 -> 1 -> 7 -> 7 -> 1 -> 2 -> 4 -> 3 -> 8 -> 9 -> 8 -> 2 -> 6 -> 7 -> 8 -> 6 -> 1 -> 6 -> 8 -> 9 -> 6 -> 7 -> 7 -> 2 -> 3 -> 2 -> 6 -> 9 -> 9 -> 9 -> 9 -> 6 -> 2 -> 6 -> 2 -> 1 -> 9 -> 4 -> 9 -> 9 -> 3 -> 3 -> 7 -> 1 -> 4 -> 4 -> 1 -> 8 -> 7 -> 5 -> 7 -> 5 -> 3 -> 6 -> 8 -> 1 -> 3 -> 6 -> 4 -> 1 -> 3 -> 9 -> 7 -> 5 -> 4 -> 1 -> 8 -> 5 -> 4 -> 1 -> 1 -> 7 -> 4 -> 8 -> 9 -> 5 -> 1 -> 4 -> 8 -> 6 -> 1 -> 8 -> 7 -> 3 -> 1 -> 3 -> 4 -> 7 -> 2 -> 3 -> 1 -> 7 -> 9 -> 6 -> 8 -> 2 -> 4 -> 4 -> 5 -> 3 -> 5 -> 4 -> 6 -> 1 -> 2 -> 6 -> 4 -> 9 -> 1 -> 9 -> 3 -> 7 -> 5 -> 8 -> 6 -> 5 -> 7 -> 7 -> 3 -> 2 -> 9 -> 2 -> 4 -> 1 -> 1 -> 4 -> 1 -> 2 -> 4 -> 1 -> 9 -> 7 -> 9 -> 4 -> 4 -> 7 -> 2 -> 4 -> 9 -> 1 -> 3 -> 2 -> 3 -> 1 -> 7 -> 8 -> 3 -> 6 -> 7 -> 5 -> 2 -> 4 -> 4 -> 8 -> 6 -> 5 -> 4 -> 8 -> 6 -> 7 -> 1 -> 2 -> 5 -> 4 -> 6 -> 5 -> 5 -> 2 -> 5 -> 6 -> 6 -> 2 -> 2 -> 1 -> 8 -> 7 -> 7 -> 7 -> 1 -> 3 -> 3 -> 1 -> 5 -> 6 -> 9 -> 8 -> 8 -> 6 -> 7 -> 8 -> 1 -> 7 -> 6 -> 8 -> 7 -> 7 -> 2 -> 1 -> 8 -> 6 -> 2 -> 9 -> 9 -> 3 -> 1 -> 9 -> 2 -> 6 -> 3 -> 5 -> 2 -> 4 -> 6 -> 8 -> 8 -> 2 -> 2 -> 2 -> 2 -> 4 -> 5 -> 1 -> 5 -> 4 -> 8 -> 1 -> 9 -> 9 -> 8 -> 7 -> 6 -> 7 -> 7 -> 5 -> 2 -> 8 -> 9 -> 2 -> 1 -> 3 -> 7 -> 4 -> 7 -> 5 -> 3 -> 5 -> 7 -> 3 -> 4 -> 9 -> 8 -> 3 -> 6 -> 5 -> 1 -> 1 -> 9 -> 7 -> 8 -> 5 -> 6 -> 6 -> 1 -> 6 -> 7 -> 1 -> 5";
        String split1[] = s.split(" -> ");
        ListNode list1 = createLinkedList(split1);

        s = "8 -> 4 -> 8 -> 7 -> 6 -> 6 -> 7 -> 9 -> 7 -> 5 -> 2 -> 4 -> 8 -> 4 -> 2 -> 1 -> 3 -> 8 -> 6 -> 7 -> 8 -> 4 -> 1 -> 8 -> 1 -> 1 -> 8 -> 9 -> 2 -> 3 -> 5 -> 3 -> 5 -> 1 -> 7 -> 9 -> 5 -> 7 -> 7 -> 7 -> 9 -> 8 -> 1 -> 3 -> 6 -> 3 -> 3 -> 3 -> 9 -> 9 -> 6 -> 3 -> 1 -> 9 -> 8 -> 5 -> 3 -> 2 -> 6 -> 6 -> 4 -> 8 -> 3 -> 6 -> 8 -> 9 -> 8 -> 5 -> 1 -> 7 -> 5 -> 4 -> 3 -> 6 -> 7 -> 1 -> 2 -> 6 -> 2 -> 8 -> 7 -> 6 -> 7 -> 4 -> 3 -> 3 -> 4 -> 5 -> 5 -> 5 -> 4 -> 6 -> 7 -> 9 -> 6 -> 3 -> 2 -> 3 -> 4 -> 3 -> 4 -> 1 -> 7 -> 9 -> 5 -> 2 -> 7 -> 4 -> 9 -> 8 -> 5 -> 2 -> 9 -> 8 -> 8 -> 5 -> 2 -> 3 -> 3 -> 2 -> 7 -> 2 -> 1 -> 8 -> 1 -> 8 -> 1 -> 7 -> 3 -> 7 -> 9 -> 4 -> 3 -> 7 -> 5 -> 1 -> 2 -> 1 -> 6 -> 1 -> 6 -> 7 -> 8 -> 1 -> 3 -> 5 -> 6 -> 2 -> 9 -> 8 -> 2 -> 6 -> 5 -> 4 -> 4 -> 2 -> 8 -> 6 -> 8 -> 3 -> 1 -> 5 -> 6 -> 7 -> 5 -> 6 -> 1 -> 5 -> 4 -> 8 -> 4 -> 8 -> 1 -> 1 -> 1 -> 7 -> 7 -> 9 -> 2 -> 6 -> 3 -> 8 -> 1 -> 8 -> 9 -> 9 -> 5 -> 6 -> 9 -> 2 -> 2 -> 8 -> 9 -> 8 -> 7 -> 1 -> 3 -> 6 -> 5 -> 7 -> 4 -> 1 -> 9 -> 8 -> 3 -> 4 -> 7 -> 4 -> 1 -> 5 -> 7 -> 9 -> 4 -> 4 -> 3 -> 1 -> 8 -> 4 -> 8 -> 1 -> 1 -> 8 -> 6 -> 3 -> 8 -> 6 -> 2 -> 7 -> 4 -> 6 -> 7 -> 8 -> 8 -> 9 -> 7 -> 9 -> 1 -> 3 -> 3 -> 7 -> 9 -> 8 -> 6 -> 4 -> 2 -> 4 -> 4 -> 8 -> 4 -> 3 -> 7 -> 2 -> 2 -> 8 -> 8 -> 9 -> 9 -> 7 -> 8 -> 2 -> 6 -> 2 -> 9 -> 8 -> 6 -> 8 -> 2 -> 5 -> 6 -> 5 -> 8 -> 6 -> 8 -> 7 -> 7 -> 1 -> 7 -> 7 -> 4 -> 6 -> 6 -> 8 -> 9 -> 8 -> 6 -> 1 -> 3 -> 4 -> 7 -> 9 -> 8 -> 2 -> 3 -> 7 -> 7 -> 7 -> 1 -> 9 -> 7 -> 7 -> 1 -> 1 -> 6 -> 7 -> 9 -> 2 -> 6 -> 7 -> 1 -> 3 -> 7 -> 6 -> 6 -> 8 -> 2 -> 1 -> 2 -> 7 -> 6 -> 8 -> 1 -> 3 -> 3 -> 9 -> 4 -> 7 -> 5 -> 7 -> 8 -> 3 -> 6 -> 9 -> 7 -> 9 -> 7 -> 5 -> 2 -> 7 -> 7 -> 8 -> 3 -> 1 -> 9 -> 8 -> 2 -> 6 -> 7 -> 6 -> 4 -> 4 -> 1 -> 7 -> 2 -> 2 -> 7 -> 3 -> 9 -> 4 -> 1";
        String split2[] = s.split(" -> ");

        ListNode list2 = createLinkedList(split2);


        ListNode list3 = createLinkedList(Arrays.asList(1));

        ListNode list4 = createLinkedList(Arrays.asList(9, 9, 9));


        list1 = addTwoNumbers(list3, list4);

        print(list1);

    }

}
