/**
 * Created by avsrivathsan on 6/23/2017.
 */
public class CheckBalancedBinaryTree {

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

    class BalancedTreeWithHeight {
        int height;
        boolean isBalanced;


        public BalancedTreeWithHeight(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }


        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }
    }

    private BalancedTreeWithHeight isBalanced(Node root) {
        if (root == null) {
            return new BalancedTreeWithHeight(-1, true);
        }
        BalancedTreeWithHeight leftTree = isBalanced(root.left);
        if (!leftTree.isBalanced()) {
            return leftTree;
        }
        BalancedTreeWithHeight rightTree = isBalanced(root.right);
        if (!rightTree.isBalanced()) {
            return rightTree;
        }
        boolean isBalanced = Math.abs(rightTree.height - leftTree.height) <= 1 ? true : false;
        int height = 1 + Math.max(rightTree.height, leftTree.height);
        return new BalancedTreeWithHeight(height, isBalanced);
    }


    public static void main(String[] args) {

    }
}
