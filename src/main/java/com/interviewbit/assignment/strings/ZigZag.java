package com.interviewbit.assignment.strings;

import java.util.ArrayList;

/**
 * Created by srivathsan on 25/10/15.
 */
public class ZigZag {

    public static String convert(String A, int B) {

        if (B <= 1)
            return A;

        ArrayList<StringBuilder> str = new ArrayList<StringBuilder>();
        int n = A.length();
        StringBuilder s;

        for (int i = 0; i < B; i++)
            str.add(new StringBuilder());

        int row = 0;
        int add = 1;

        for (int i = 0; i < n; i++) {
            s = str.get(row);
            s.append(A.charAt(i));
            row += add;
            if (row == B - 1)
                add = -1;
            else if (row == 0)
                add = 1;
        }

        StringBuilder res = new StringBuilder();

        for (StringBuilder ss : str)
            res.append(ss);

        return res.toString();

    }

    public static String convert1(String a, int b) {

        int row = b;

        if ( row <= 1 || row >= a.length()) {
            return a;
        }
        StringBuffer output = new StringBuffer();
        int maxVal = (row - 2) * 2 + 1;

        for (int i = 0; i < row ; i++)  {
            int nextIndex = -1;
            output.append(a.charAt(i));
            int previousDiff = -1;
            if ( i  == 0 || i == row -1) {
                nextIndex = i +maxVal + 1;
            } else {
                nextIndex = ( row -i -2) * 2 + 1 + i +1 ;
                previousDiff = ( row -i -2) * 2 + 1;
            }

            while (nextIndex < a.length()) {
                output.append(a.charAt(nextIndex));
                if ( i  == 0 || i == row -1) {
                    nextIndex = nextIndex + maxVal + 1;
                } else {
                    nextIndex = maxVal - previousDiff -1 + nextIndex + 1;
                    previousDiff = maxVal - previousDiff -1;

                }

            }

        }
        return  output.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    }
}
