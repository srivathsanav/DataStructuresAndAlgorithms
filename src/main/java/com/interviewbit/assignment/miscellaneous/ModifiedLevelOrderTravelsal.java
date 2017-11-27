import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by avsrivathsan on 8/2/2017.
 */
public class ModifiedLevelOrderTravelsal {

    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
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

    private static void modifiedLevelOrderTraversal(Node root) {
        List<List<Integer>> traversalList = new ArrayList<>();
        if (root != null) {
            Queue<Node> level1Queue = new LinkedList<>();
            level1Queue.add(root);
            List<Integer> currentResults = new ArrayList<>();
            Queue<Node> level2Queue = new LinkedList<>();
            while (!level1Queue.isEmpty()) {
                Node node = level1Queue.poll();
                if (node.left != null) {
                    level2Queue.add(node.left);
                }
                if (node.right != null) {
                    level2Queue.add(node.right);
                }
                currentResults.add(node.data);
                if (level1Queue.isEmpty()) {
                    traversalList.add(currentResults);
                    currentResults = new ArrayList<>();
                    while(!level2Queue.isEmpty()) {
                        level1Queue.add(level2Queue.poll());
                    }
                }
            }
        }
    }
}
