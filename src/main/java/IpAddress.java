package com.interviewbit.assignment;

import java.util.ArrayList;

/**
 * Created by srivathsan on 24/10/15.
 */
public class IpAddress {

    public static ArrayList<String> restoreIpAddresses(String a) {
        ArrayList<String> output = new ArrayList<String>();
        if (a.length() < 4 || a.length() > 12) {
            return  output;
        }

        int min = 1;
        int max = 3;


        for (int i =min; i <= max; i++)  {
            String iPart = "";
            if (isValid(a.substring(0,i))){
                iPart = a.substring(0,i);
                for (int j = min; j <=max ; j++) {
                    if (i + j <= a.length() - (2 * min) && i + j >= a.length() - (2 * max)) {

                        if (isValid(a.substring(i, i + j))) {
                            String jPart = "";
                            jPart  = a.substring(i, i + j);


                            for (int k = min; k <= max; k++) {
                                if (i + j + k <= a.length() - min && i + j + k >= a.length() - max) {
                                    if (isValid(a.substring(i + j, i + j + k))) {
                                        String kPart  = "";
                                        kPart = a.substring(i + j, i + j + k);

                                        for (int l = min; l <= max; l++) {
                                            String lPart = "";
                                            if (i + j + k + l == a.length()) {
                                                if (isValid(a.substring(i + j + k, i + j + k + l))) {
                                                    lPart = a.substring(i + j + k, i + j + k + l);

                                                    if (i + j + k + l == a.length())
                                                        output.add(new StringBuffer(iPart).append(".").append(jPart).append(".").append(kPart).append(".").append(lPart).toString());

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        return output;
    }

    private static boolean isValid (String ipAddress)  {
        if (Integer.valueOf(ipAddress) != 0  && ipAddress.charAt(0) == '0')  {
            return  false;
        }
        if (Integer.valueOf(ipAddress) == 0  && ipAddress.length() > 1)  {
            return  false;
        }
        if (Integer.valueOf(ipAddress) < 0 || Integer.valueOf(ipAddress) > 255) {
            return  false;
        }
        return  true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
