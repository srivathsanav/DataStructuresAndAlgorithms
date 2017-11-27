/**
 * Created by avsrivathsan on 2/8/2017.
 */
public class CeilBST {

    public int ceilBST(Node node, int number) {
        if (node == null) {
            return -1;
        }
        if (node.data == number) {
            return node.data;
        } else if (node.data < number) {
           return ceilBST(node.right, number);

        } else  {
           int ceil =  ceilBST(node.left, number);
            return (ceil >= number) ? ceil : node.data;
        }
    }

    public int floorBST(Node node, int number) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.data == number) {
            return node.data;
        }
        if (node.data > number) {
            return  floorBST(node.left, number);
        }

        else  {
            int floor = floorBST(node.right, number);
            return (floor <= number ) ? floor : node.data;
        }


    }
}
