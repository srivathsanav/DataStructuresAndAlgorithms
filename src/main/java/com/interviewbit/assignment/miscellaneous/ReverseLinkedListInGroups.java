/**
 * Created by avsrivathsan on 11/6/2017.
 */
public class ReverseLinkedListInGroups {


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        int count = 0;
        ListNode previous = null , next = null;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (count < k) {
            return head;
        } else {
            current = head;
            count = 0;
        }
        while (current != null && count<k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        return previous;
    }



}
