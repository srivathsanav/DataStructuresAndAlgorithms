package com.datastructures;

/**
 * Created by srivathsan on 23/02/17.
 */
public class TrieGayle {
    private Node root = new Node();

    private static final int R = 256;

    public void put (String key, String value) {
        //put( key, value, 0);
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

         Object value;

         Node[] next = new Node[R];

        int size;

        private void put(String key, String value, int d) {

            if (d == key.length()) {
                return;
            }
            char letter = key.charAt(d);
            Node children = next[letter];

            if (children == null) {
                children = new Node();
                children.value = letter;
            }
            children.put(key, value, d+1);

        }
    }
}
