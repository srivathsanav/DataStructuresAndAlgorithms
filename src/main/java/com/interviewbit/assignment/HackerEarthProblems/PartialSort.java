package com.interviewbit.assignment.HackerEarthProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 20/11/15.
 */
public class PartialSort {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int T = Integer.parseInt(line);
            for (int i = 0; i < T; i++) {
                String[] numArray = br.readLine().split(" ");
                int N = Integer.parseInt(numArray[0]);
                int K = Integer.parseInt(numArray[1]);
                int M = Integer.parseInt(numArray[2]);
                List<String> input = new ArrayList<String>();

                for (int j = 0 ; j < N; j++) {
                    input.add(br.readLine());
                }
                System.out.println((sort( input, K, M)));
            }



        } catch (IOException ex) {
            System.out.println(ex);
        }

       /* System.out.println(sort(Arrays.asList("ab", "a"), 1, 3));
        List l = Arrays.asList("ab", "a");
        Collections.sort(l);
        System.out.println(l);*/

    }

    private static String sort(List<String> inputStrings, int k, int m) {

        if (k > inputStrings.size() || k < 1) {
            return "";
        }

        for (int i = 0; i < inputStrings.size(); i++) {
            for (int j = i + 1; j < inputStrings.size(); j++) {
                m = findSmaller(inputStrings.get(i).length(), inputStrings.get(j).length(), m);
                for (int count = 0; count < m; count++) {
                    if (inputStrings.get(i).charAt(count) == inputStrings.get(j).charAt(count)) {
                        continue;
                    }
                    if (inputStrings.get(i).charAt(count) > inputStrings.get(j).charAt(count)) {
                        String temp = inputStrings.get(i);
                        inputStrings.set(i, inputStrings.get(j));
                        inputStrings.set(j, temp);
                    }
                    break;
                }
            }
            if (i == k - 1) {
                return inputStrings.get(i);
            }
        }

        return inputStrings.get(k - 1);
    }



    private static int findSmaller(int s1Length, int s2Length, int m)  {
        if ( m <= s1Length && m  <= s2Length) {
            return m;
        } else if (s1Length <= m && s1Length <= s2Length) {
            return s1Length;
        }
        return s2Length;
    }
}
