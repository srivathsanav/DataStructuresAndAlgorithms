package com.interviewbit.assignment;

import java.util.ArrayList;

/**
 * Created by srivathsan on 25/10/15.
 */
public class Version {

    public static int compareVersion(String a, String b) {

        ArrayList<Double> valueArray1 = createValueArray(a);
        ArrayList<Double> valueArray2 = createValueArray(b);


        int max = ( valueArray1.size() > valueArray2.size() ? valueArray1.size()  : valueArray2.size());

        for (int i =0; i < max; i++) {
            double indexValue1 = 0;
            if ( i < valueArray1.size()) {
                indexValue1 = valueArray1.get(i);
            }

            double indexValue2 = 0;
            if ( i < valueArray2.size()) {
                indexValue2 = valueArray2.get(i);
            }

            if (indexValue1 > indexValue2) {
                return 1;
            } else if (indexValue1 < indexValue2) {
                return -1;
            }

        }
       return  0;
    }

    private static ArrayList<Double> createValueArray ( String a) {
        ArrayList<Double> valueArray = new ArrayList<Double>();
        StringBuffer sb = new StringBuffer();
        for (int i =0 ; i < a.length(); i++) {
            if (a.charAt(i) != '.') {
                sb.append(a.charAt(i));
            } else {
                if (sb.length() > 0) {
                    valueArray.add(Double.valueOf(sb.toString()));
                } else {
                    valueArray.add(Double.valueOf(0));

                }
                sb = new StringBuffer();

            }
        }
        if (sb.length() > 0) {
            valueArray.add(Double.valueOf(sb.toString()));
        }
        return  valueArray;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("4444371174137455", "0.1.101.0.1.0.0.0.0.0.0.10"));

    }
}
