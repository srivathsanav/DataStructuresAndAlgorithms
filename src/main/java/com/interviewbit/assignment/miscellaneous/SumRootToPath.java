/**
 * Created by avsrivathsan on 8/24/2017.
 */
public class SumRootToPath {

  static   class BinaryTreeNode {
        BinaryTreeNode left;

        BinaryTreeNode right;

        int data;

        public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    private static int sumRootToPaths (BinaryTreeNode root, int partialSum) {
        if (root == null) {
            return 0;
        }
        partialSum = 2 * partialSum + root.data;

        if (root.left == null && root.right == null) {
            return partialSum;
        }

        return sumRootToPaths(root.left, partialSum) + sumRootToPaths(root.right, partialSum);
    }

    public static void main(String[] args) {
        BinaryTreeNode left = new BinaryTreeNode(null, null , 0);
        BinaryTreeNode right = new BinaryTreeNode(null, null , 1);
        BinaryTreeNode root = new BinaryTreeNode(left, right, 1);
        System.out.println(sumRootToPaths(root, 0));

    }
}
