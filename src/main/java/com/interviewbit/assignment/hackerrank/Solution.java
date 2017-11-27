import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/5/17.
 */
public class Solution {

    static void finalPrice(int[] prices) {
        long discount = 0;
        List<Integer> noDiscountList = new ArrayList<>();
        for (int i =0; i < prices.length; i++) {
            boolean disCounted = false;
            for (int j = i +1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = discount + prices[i] - prices[j];
                    disCounted = true;
                    break;
                }
            }
            if (!disCounted) {
                noDiscountList.add(i);
                discount = discount + prices[i];
            }
        }
        System.out.println(discount);
        for (Integer noDiscountIndex  : noDiscountList) {
            System.out.print(noDiscountIndex + " ");
        }
    }


    static void finalPrice1(int[] prices) {
        long discount = 0;
        // Construct minimum price list from backwards
        int[] minimumPriceList = new int[prices.length];
        int minimum = Integer.MAX_VALUE;
        for (int i = prices.length -1 ; i >= 0; i--) {
            if (prices[i] < minimum) {
                minimum = prices[i];
            }
            minimumPriceList[i] = minimum;
        }

        List<Integer> noDiscountedList = new ArrayList<>();

        for (int i =0; i < prices.length; i++) {
            if (prices[i] > minimumPriceList[i]) {
                noDiscountedList.add(i);
                discount = discount + prices[i];
            } else if (prices[i] <= minimumPriceList[i]) {
                discount = discount + prices[i] - minimumPriceList[i];
            }
        }
        System.out.println(discount);
        for (Integer noDiscountIndex  : noDiscountedList) {
            System.out.print(noDiscountIndex + " ");
        }

    }

   /* public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt();
        int[] prices = new int[myInt];
        for (int i = 0; i < myInt; i++) {
            prices[i] = scanner.nextInt();
        }
       // finalPrice(prices);
        finalPriceOptimal(prices);

    }*/

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int avg_size = 0;
        avg_size = Integer.parseInt(in.nextLine().trim());
        int[] avg = new int[avg_size];
        for(int i = 0; i < avg_size; i++) {
            int avg_item;
            avg_item = Integer.parseInt(in.nextLine().trim());
            avg[i] = avg_item;
        }

        finalPrice1(avg);
        //bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }



}
