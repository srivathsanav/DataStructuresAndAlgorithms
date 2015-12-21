package com.interviewbit.assignment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 06/11/15.
 */
public class CopyList {


     class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
      };

    public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) {
                return null;
            }

        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

        int count = 0;
        RandomListNode temp = head;
        while (temp != null) {
            map.put(count, temp);
            count++;

            temp = temp.next;
        }
        int size = count;
        count = 0;
        temp = head;

        RandomListNode returnList = null;

        RandomListNode temp1 = null;
        while (temp != null) {
            if (map.get(count) != null) {
                if (returnList == null) {
                    returnList = new RandomListNode(map.get(count).label);
                    if (temp.random != null) {

                        int value = temp.random.label;

                       // temp.random.label = temp.random.label % (size +1);

                       // if (temp.random.label == size) {
                         //   returnList.random = null;
                       // } else {
                            returnList.random = temp.random;
                        //}
                    }
                    temp1 = returnList;

                } else {
                    temp1.next = new RandomListNode(map.get(count).label);
                    if (temp.random != null) {
                        int value = temp.random.label;

                       // temp.random.label = temp.random.label % (size+1);

                        //if (temp.random.label == size) {
                          //  temp1.next.random = null;
                        //} else {

                            temp1.next.random = temp.random;
                        //}

                    }
                    temp1 = temp1.next;

                }

                count++;
            }
            temp = temp.next;
        }
        temp1.next = null;
        return returnList;
    }


    private  RandomListNode createLinkedList(List<Integer> numbers, List<Integer> random) {
        RandomListNode previousNode = new RandomListNode(numbers.get(0));
        previousNode.random = new RandomListNode(random.get(0));
        RandomListNode head = previousNode;
        for (int i =1; i < numbers.size(); i++) {
            RandomListNode y = new RandomListNode(numbers.get(i));
            y.random = new RandomListNode(random.get(i));
            previousNode.next = y;
            previousNode = y;
        }
        return head;
    }


    public static void print (RandomListNode a) {
        while (a != null)  {
            System.out.println(a.label);
            if (a.random !=  null)
            System.out.println(a.random.label);
            a = a.next;
        }
    }


    public static void main(String[] args) {
        CopyList c = new CopyList();
        RandomListNode r = c.createLinkedList(Arrays.asList(1), Arrays.asList(3,1,1));
        RandomListNode r1 = c.copyRandomList(r);
        System.out.println("\n  ******");
        c.print( r1);
    }
}

