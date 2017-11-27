import sun.reflect.generics.tree.Tree;

/**
 * Created by avsrivathsan on 6/19/2017.
 */
public class TreeNode {

    private TreeNode left, right, parent;

    private int data;

    public TreeNode(int data) {

    }

    public void setLeftChild(TreeNode node) {
        if (node != null) {
            this.left = node;
        }
    }

    public void setRightChild(TreeNode node) {
        if (node != null) {
            this.right = node;
        }
    }

    public void insertIntoTree(int data) {
        if (this .data <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(data));
            } else {
                left.insertIntoTree(data);
            }
        }
    }


}
