package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 31/10/15.
 */
public class DeleteDupllicatesLinkedList2 {


    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null) return head;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper, cur = head;
        while(cur!=null)
        {
            while(cur.next!=null && pre.next.val==cur.next.val)
                cur = cur.next;
            if (pre.next == cur)
                pre = pre.next;
            else
                pre.next = cur.next;
            cur = cur.next;
        }
        return helper.next;
    }
    public static ListNode deleteDuplicates1(ListNode a) {

        if (a == null || a.next == null) {
            return a;
        }

        ListNode temp = a;
        ListNode previous = a;
        while ( temp != null && temp.next != null) {
            int nextVal = temp.val;
            if (nextVal == temp.next.val) {
                if (temp.next.next != null) {
                    if (previous != null) {
                        previous.next = temp.next.next;
                    } else {
                        previous = temp.next.next;
                    }
                } else {
                    if (previous != null) {
                        previous.next = null;
                    }
                }
                temp = temp.next;
            } else {
                previous = previous.next;
                temp = temp.next;
            }
        }


        return  a;
    }



    public static ListNode deleteDuplicates(ListNode a) {

           if (a == null || a.next == null) {
               return a;
           }

          HashMap<Integer,Integer>    values = new HashMap<Integer, Integer>();
           ListNode temp = a;
           while ( temp.next != null) {
               int nextVal = temp.val;
               if (nextVal == temp.next.val) {
                   values.put(nextVal, nextVal);
                   if (temp.next.next != null) {
                       temp.next = temp.next.next;
                   } else {
                       temp.next = null;
                   }
               } else {
                   temp = temp.next;
               }
           }

            temp = a;

        while(temp.next != null) {
            if (values.get(temp.next.val) != null) {
                 temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        if (values.get(a.val) != null)  {
            a = a.next;
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
        for (int i =1; i < numbers.size(); i++) {
            ListNode y = new ListNode(numbers.get(i));
            previousNode.next = y;
            previousNode = y;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode list = createLinkedList(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3,3, 4, 4, 4, 4, 4, 10));

        ListNode list1 = createLinkedList(Arrays.asList(1,2,3,4,4,4));
        list1 = deleteDuplicates2(list1);
        print(list1);
    }
}
