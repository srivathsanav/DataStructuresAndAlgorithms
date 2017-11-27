import java.util.Iterator;
import java.util.Stack;
import java.util.function.Consumer;

/**
 * Created by avsrivathsan on 9/4/2017.
 */
public class BinaryTreeResearch {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static Node insertIntoBinaryTree(Node root, int data) {
        if (root == null) {
            Node node = new Node(data, null, null);
            return node;
        } else if (root.data <= data) {
            root.right = insertIntoBinaryTree(root.right, data);
        } else {
            root.left = insertIntoBinaryTree(root.left, data);
        }
        return root;
    }

    private static class BinaryTreeIterator implements Iterator<Node> {
        Stack<Node> elements = new Stack<>();

        public BinaryTreeIterator(Node root) {
            while (root != null) {
                elements.push(root);
                root = root.left;
            }
        }

        @Override

        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public Node next() {
            Node current  = null;
            if(!elements.isEmpty()) {
                 current = elements.pop();
                Node right = current.right;
                if(right != null) {
                    elements.push(right);
                    while (right.left != null) {
                        elements.push(right.left);
                        right = right.left;
                    }
                }
            }
            return current;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super Node> action) {

        }
    }

    private static void printBinaryTreeInInorder(Node node) {
        if (node == null) {
            return;
        }
        printBinaryTreeInInorder(node.left);
        System.out.println(node.data);
        printBinaryTreeInInorder(node.right);
    }

    public static void main(String[] args) {
        Node root = insertIntoBinaryTree(null, 10);
        root = insertIntoBinaryTree(root, 8);
        root = insertIntoBinaryTree(root, 3);
        root = insertIntoBinaryTree(root, 12);
        root = insertIntoBinaryTree(root, 14);
        root = insertIntoBinaryTree(root, 13);
        root = insertIntoBinaryTree(root, 9);
        root = insertIntoBinaryTree(root, 4);
        root = insertIntoBinaryTree(root, 5);
        root = insertIntoBinaryTree(root, 6);
        root = insertIntoBinaryTree(root, 7);

        printBinaryTreeInInorder(root);

        System.out.println("************************");
        Iterator<Node> iter = new BinaryTreeIterator(root);

        while (iter.hasNext()) {
            System.out.println(iter.next().data);
        }


    }

}
