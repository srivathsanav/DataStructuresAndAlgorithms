package com.interviewbit.assignment.strings;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class LCP {
    public static String longestCommonPrefix(ArrayList<String> a) {
        StringBuffer sb = new StringBuffer();
        if (a.size() > 0) {
            if (a.size() == 1) {
                return a.get(0);
            }

            String first = a.get(0);
            for (int i = 0; i <= first.length() -1; i++) {
                if (a.get(0).charAt(i) != ' ') {
                    for (int j = 1 ; j < a.size(); j++) {
                        if (i > (a.get(j).length() -1) ||  (a.get(0).charAt(i) != a.get(j).charAt(i))) {
                            return sb.toString();
                        }
                    }
                    sb.append(a.get(0).charAt(i));
                } else {
                    return "";
                }
            }
        }
        return sb.toString();
    }
}
