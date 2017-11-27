/**
 * Created by avsrivathsan on 8/24/2017.
 */
public class LCA1 {

    class BinaryTreeNode {
        BinaryTreeNode left;

        BinaryTreeNode right;

        int data;

        public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right) {
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    class Status {
        BinaryTreeNode ancestor;

        int numOfNodes;


        public Status(BinaryTreeNode ancestor, int numOfNodes) {
            this.ancestor = ancestor;
            this.numOfNodes = numOfNodes;
        }

    }

    private  BinaryTreeNode computeLCA(BinaryTreeNode tree, BinaryTreeNode n1, BinaryTreeNode n2) {
        return computeLCAHelper(tree, n1, n2).ancestor;
    }

    private  Status computeLCAHelper(BinaryTreeNode tree, BinaryTreeNode n1, BinaryTreeNode n2) {
        if (tree == null) {
            return new Status(null, 0);
        }
        Status leftTreeResult = computeLCAHelper(tree.left, n1, n2);

        if (leftTreeResult.numOfNodes == 2) {
            return  new Status( leftTreeResult.ancestor, leftTreeResult.numOfNodes);
        }

        Status rightTreeResult = computeLCAHelper(tree.right, n1, n2);

        if (rightTreeResult.numOfNodes == 2) {
            return  new Status( rightTreeResult.ancestor, rightTreeResult.numOfNodes);
        }

        int totalResult = leftTreeResult.numOfNodes + rightTreeResult.numOfNodes + (tree == n1 ? 1 : 0) + (tree == n2 ? 1 : 0);

      return new Status(tree, totalResult);


    }
}
