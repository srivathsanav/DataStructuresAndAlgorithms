package com.datastructures;

/**
 * Created by srivathsan on 23/02/17.
 */
public class TrieSedgewick {


    private Node root = new Node();

    private static final int R = 256;

    public void put (String key, String value) {
        put(root, key, value, 0);
    }

    private Node put(Node node, String key, String value, int d) {
        if (node == null) {
            node = new Node();
        }
        if (d == key.length()) {
            node.value = value;
            return node;
        } else {
            char letter = key.charAt(d);
            node.next[letter] = put(node.next[letter], key, value, d+1);
        }
        return node;
    }

    public String get(String key) {
        Node node = get(root, key, 0);
        if (node == null) {
            return null;
        } else {
            return (String)node.value;
        }
    }

    private Node get(Node root, String key, int d) {
        if (root == null) {
            return null;
        }
        if (d == key.length()) {
            if (root.value != null) {
                return root;
            } else {
                return null;
            }
        }
        char letter = key.charAt(d);
        return get(root.next[letter], key, d++);

    }


    private class Node {

        private Object value;

        private Node[] next = new Node[R];
    }
}
