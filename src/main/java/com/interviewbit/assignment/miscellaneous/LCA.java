/**
 * Created by avsrivathsan on 2/7/2017.
 */
public class LCA {

    Node findLCA (Node current, Node n1, Node n2) {
        if (current == null) {
            return null;
        }
        if (current == n1 || current == n2) {
            return current;
        }
        Node left = findLCA(current.left, n1, n2);
        Node right = findLCA(current.right, n1, n2);

        if (left != null && right!= null) {
            return current;
        } else if (left == null && right != null) {
            return right;
        } else if (left != null && right == null) {
            return left;
        } else   {
            return null;
        }
    }
}
