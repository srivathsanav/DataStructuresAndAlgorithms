package com.datastructures;

/**
 * Created by srivathsan on 18/02/17.
 */
public class MyHashMap {

    private static int INITIAL_CAPACITY = 10;

    private Node[] nodes = new Node[INITIAL_CAPACITY];

    private int size = 0;

    public int hashCode(String key) {
        return key.hashCode() % nodes.length;
    }

    public Object get(String key) {
        int hash = hashCode(key);
        Node head = nodes[hash];

        while (head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public Object remove(String key) {
        int hash = hashCode(key);
        Node head = nodes[hash];
        Node previous = null;

        boolean found = false;
        while (head != null) {
            if(head.key.equals(key)) {
                found = true;
                break;
            }
            previous = head;
            head = head.next;
        }

        if (!found) {
            return null;
        } else {
            if (previous != null) {
                previous.next = head.next;
            } else {
                nodes[hash] = head.next;
            }
            size--;
        }
        return head.value;
    }

    private void ensureCapacity() {
        if (size == nodes.length) {
            // expand
            System.arraycopy(nodes, 0, nodes, 0, 2 * nodes.length);
        }
    }

    public void put(String key, String value) {
        ensureCapacity();
        int hash = hashCode(key);
        if (nodes[hash] == null) {
            Node node = createNewNode(key, value, hash);
            nodes[hash] = node;
        } else {
            //Occupied
            Node head = nodes[hash];

            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            Node node = createNewNode(key, value, hash);
            head = nodes[hash];
            node.next = head;
            nodes[hash] = node;

        }
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private Node createNewNode(String key, String value, int hash) {
        Node node = new Node(key, value);
        return node;
    }

    private static class Node {

        private Node next;

        private String key;

        private Object value;

        public Node(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    public static void main(String[] args)
    {
        MyHashMap map = new MyHashMap();
        map.put("this","1" );
        map.put("coder","2" );
        map.put("this","4" );
        map.put("hi", "5" );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}

