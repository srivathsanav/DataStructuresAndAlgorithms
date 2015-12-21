package com.interviewbit.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 18/11/15.
 */
public class SumGame2 {

    public static void main(String[] args) {

       try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            List<Integer> numList = new ArrayList<Integer>();
            for (int i = 0; i < N; i++) {
                numList.add(Integer.parseInt(br.readLine()));
            }

            for (int i = 0; i < numList.size(); i++) {
                System.out.println(countNumberOfWays(numList.get(i)));
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private static int countNumberOfWays(int number) {
        if (number <= 3) {
            return 0;
        }
        int count = 0;
        int currentSum = 0;


        for (int i = 1; i <= number / 4; i++) {
            currentSum = i;
            if (currentSum >= number)
                break;
            for (int j = i; j <= number / 3; j++) {
                currentSum = i + j;
                if ((currentSum >= number)) {
                    break;
                }
                for (int k = j; k <= number / 2; k++) {
                    currentSum = i + j + k;
                    if (currentSum >= number) {
                        break;
                    }
                    int l = number - currentSum;
                    if ( l >= k) {
                        count++;
                    }
                }
            }

        }
        return count;
    }


}
