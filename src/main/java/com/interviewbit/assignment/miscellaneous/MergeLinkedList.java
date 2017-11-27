/**
 * Created by avsrivathsan on 6/9/2017.
 */
public class MergeLinkedList {

    public Node mergeLinkedList(Node l1, Node l2) {
        Node dummyHead = new Node(0, null);
        Node current = dummyHead;
        Node p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            dummyHead = dummyHead.next;
        }
        current.next = p1 == null ? p2  :p1;
        return dummyHead.next;
    }
}
