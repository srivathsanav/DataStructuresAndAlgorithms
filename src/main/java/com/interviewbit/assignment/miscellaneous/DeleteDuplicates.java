import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by avsrivathsan on 7/24/2017.
 */
public class DeleteDuplicates {

    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }

    }

    private Node deleteDuplicates(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node first = node;
        while (first != null) {
            Node second = first.next;
            while (second != null && first.data == second.data) {
                second = second.next;
            }
            first.next = second;
            first = first.next;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] count = new int[128];
        String input = "sdfdfsdfd";
        String other = "afadfdfdfdds";
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)]++;
        }

        for (int i = 0; i < other.length(); i++) {
            count[other.charAt(i)]--;
            if (count[other.charAt(i)] < 0) {
                System.out.println("crap");
            }
        }
    }
}
