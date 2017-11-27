import java.util.Scanner;

/**
 * Created by srivathsan on 10/7/17.
 */
public class ChocolateCover {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int c = in.nextInt();
            int m = in.nextInt();
            printTotalChocolateCovers(n, c, m);
        }
    }

    private static void printTotalChocolateCovers (int numberOFChocolates, int cost, int wrapperOffer) {
        long totalChocolates = numberOFChocolates/cost;
        long currentChocolateWrapper = totalChocolates;

        while (currentChocolateWrapper >= wrapperOffer) {
            long remaining = currentChocolateWrapper % wrapperOffer;
            currentChocolateWrapper = currentChocolateWrapper/wrapperOffer;
            totalChocolates = totalChocolates + currentChocolateWrapper;
            currentChocolateWrapper =  currentChocolateWrapper + remaining;
        }
        System.out.println(totalChocolates);
    }
}
