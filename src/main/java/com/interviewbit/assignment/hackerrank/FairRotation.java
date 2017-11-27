import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class FairRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        fairRotation(B);
    }


    private static void fairRotation(int[] input) {
        if (!isEvenArray(input)) {
            System.out.println("NO");
        } else {
            long noOfBreads = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i]%2 != 0) {
                    for (int j = i + 1; j < input.length; j++) {
                        if (input[j]%2 != 0) {
                            //System.out.println(input[i] + "    " + input[j]);
                           // System.out.println(i + "  " + j);
                            int distance = j - i;
                            //System.out.println(distance);
                            noOfBreads = noOfBreads + distance * 2;
                            //System.out.println(noOfBreads);
                            i = j;
                            break;
                        }
                    }
                }
            }
            System.out.println(noOfBreads);
        }

    }

    private static boolean isEvenArray(int[] input) {
        long sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sum + input[i];
        }
        return sum%2 == 0;
    }
}
