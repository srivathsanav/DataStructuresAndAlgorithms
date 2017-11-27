import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by avsrivathsan on 7/27/2017.
 */
public class PostOrderTraversal {

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

    public void postOrder(Node root) {
        if (root == null)
            return;
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        stack.add(root);
        List<Integer> postOrderSequence = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node cur = stack.peek();
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    //leaf node
                    postOrderSequence.add(cur.data);
                    stack.pop();
                }
            } else if (cur.left == prev) {
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    postOrderSequence.add(cur.data);
                    stack.pop();
                }
            } else {
                postOrderSequence.add(cur.data);
                stack.pop();
            }
            prev = cur;
        }

        for (Integer element : postOrderSequence) {
            System.out.println(element + " ");
        }
    }

    public static void main(String[] args) {

    }
}
