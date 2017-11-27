import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by avsrivathsan on 2/7/2017.
 */
public class LevelOrderTraversalReverse {

    public void reverseLevelOrderTraversal ( Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Stack<Node> stack = new Stack<>();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            stack.push(current);
        }
    }
}
