package com.datastructures;

/**
 * Created by srivathsan on 30/03/17.
 */
public class CoinChange {

    private static long makeCoinChange(int[] coins, int money, int index) {
        if (money == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeCoinChange(coins, remaining, index + 1);
            amountWithCoin = amountWithCoin + coins[index];
        }

        return ways;
    }

    public static void main(String[] args) {
        System.out.println(makeCoinChange(new int[]{20, 10, 5} , 15, 0));
    }

}
