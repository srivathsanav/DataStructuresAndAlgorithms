import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by avsrivathsan on 7/24/2017.
 */
public class InorderSuccessor {

    class Node {
        int data;
        Node left;
        Node right;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node findInorderSuccessor(Node root, Node node) {
        Node minNode = null;
        // Find min value in right subtree
        if (node.right != null) {
            minNode = findMinValueInRightSubTree(node.right);
            return minNode;
        }
        Node successor = null;
        while (root != null) {
            if (node.data < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    private Node findMinValueInRightSubTree(Node n) {
        Node minNode = n;
        while (minNode.left != null) {
            minNode = minNode.left;
        }
        return minNode;
    }

    private void inOrderTraversal(Node root) {
        Stack<Node> elements = new Stack<>();
        while(root != null || !elements.empty()) {
             if (root != null) {
                 elements.push(root);
                 root = root.left;
             } else {
                 Node current = elements.pop();
                 System.out.println(current.data);
                 root = current.right;
             }
        }
    }

    private void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static int getHeight(Node root){
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }

}
