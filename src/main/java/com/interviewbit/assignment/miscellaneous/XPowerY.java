/**
 * Created by avsrivathsan on 8/21/2017.
 */
public class XPowerY {

    private static double xPowerY(double x , double y) {
        double result = 1.0;
        while (y > 1) {
            if (y %2 == 1) {
                result = result* x;
                y  = y - 1;
            } else {
                result = result * x * x;
                y = y/2;
            }

        }
        //System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(xPowerY(3, 5));
    }
}
