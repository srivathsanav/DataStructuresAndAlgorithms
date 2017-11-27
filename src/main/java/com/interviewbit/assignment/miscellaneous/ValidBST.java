/**
 * Created by avsrivathsan on 2/7/2017.
 */
public class ValidBST {

    public boolean isValidBST(Node root, int min, int max) {
        if ( root == null) {
            return true;
        }
        if (root.data <= min || root.data > max) {
            return false;
        }
        return isValidBST(root.left, min, root.data) &&
                isValidBST(root.right, root.data, max );
    }

    public static void main(String[] args) {

    }
}
