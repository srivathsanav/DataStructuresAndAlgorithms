package com.caching;

/**
 * Created by srivathsan on 31/03/16.
 */
public class Mymap {


    private Node[] nodes;

    private int capacity = 10;

     public Mymap(int capacity) {
         this.capacity = capacity;
         nodes = new Node[capacity];
     }

    class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value ) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void put (String key, String value) {
        if (nodes[hashCode(key)] != null) {
            boolean found = false;
            Node n = nodes[hashCode(key)];
            for ( Node x = n; x != null; x = x.getNext()) {
                if (x.getKey().equals(key)) {
                    x.setValue(value);
                    found = true;
                }
            }
            if (!found) {
                Node node = new Node(key, value);
                node.setNext(null);
                n.setNext(node);
            }

        } else {
            Node node = new Node(key, value);
            node.setNext(null);
            nodes[hashCode(key)] = node;

        }
    }

    public String get(String key) {
        Node node = nodes[hashCode(key)];
        Node n;
        if (node != null) {
            for (n = nodes[hashCode(key)]; n != null; n = n.getNext()) {
                if (n.getKey().equals(key)) {
                    return n.getValue();
                }
            }
        }
        return  null;
    }


    public int hashCode(String key) {
       return new Integer(key) % 10;
    }


    public static void main(String[] args) {
        Mymap map = new Mymap(10);
        map.put("1", "A");
        map.put("11", "X");

        map.put("2","B");
        map.put("3", "C");
       // map.put("1", "D");

        System.out.println(map.get("1"));
    }

}
