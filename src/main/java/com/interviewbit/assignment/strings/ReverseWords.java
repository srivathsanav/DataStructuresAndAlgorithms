package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 14/01/16.
 */
public class ReverseWords {

        public static String reverseWords(String a) {
            char[] input = a.toCharArray();
            StringBuffer sb = new StringBuffer();
            int startPos = -1;
            int endPos = -1;
            boolean endFound = false;
            boolean startFound = false;
            boolean spaceFound = false;
            for (int i = a.length() -1 ; i >=0 ; i--) {
                if ((input[i] != ' ' && !endFound)) {
                    endPos = i;
                    endFound = true;
                }
                if ((input[i] == ' ' || i ==0) && endFound) {
                    startFound = true;
                    if (input[i] != ' ') {
                        startPos = i;
                    } else{
                        startPos = i+1;
                    }


                }
                if (input[i] == ' ' && !spaceFound) {
                    spaceFound = true;
                }
                if (endFound && startFound) {
                    for (int j = startPos; j <= endPos; j++) {
                        sb.append(input[j]);
                    }
                    if (spaceFound ) {
                        for (int temp = i-1 ; temp >=0; temp--) {
                            if (input[temp] != ' ') {
                                sb.append(" ");
                                break;
                            }
                        }

                    }

                    endFound = false;
                    startFound = false;
                    spaceFound = false;
                }
            }

            return sb.toString();
        }




}
