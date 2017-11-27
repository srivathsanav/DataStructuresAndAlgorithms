import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity = 0;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }

        Node node = map.get(key);

        if (node != head) {
            removeFromLinkedList(node);
            insertItemAtFrontOfLinkedList(node);
        }

        return head.value;
    }

    private void removeFromLinkedList(Node node) {
        if (node == null)
            return;
        if (node.next != null)
            node.next.prev = node.prev;
        if (node.prev != null)
            node.prev.next = node.next;
        if (node == tail)
            tail = node.prev;
        if (node == head)
            head = node.next;
    }

    private void insertItemAtFrontOfLinkedList(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private boolean removeKey(int key) {
        Node node = map.get(key);
        removeFromLinkedList(node);
        map.remove(key);
        return true;
    }

    public void put(int key, int value) {
        removeKey(key);

        if (isFull() && tail != null) {
            removeKey(tail.key);
        }
        Node node = new Node(key, value);
        insertItemAtFrontOfLinkedList(node);
        map.put(key, node);

    }

    private boolean isFull() {
        if (this.capacity == map.size()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 3 /* capacity */ );

        cache.put(1, 1);
        //cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    class Node {
        Node prev ;
        Node next;
        int key;
        int value;

        public Node() {

        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
}

