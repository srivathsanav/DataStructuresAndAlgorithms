package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 14/01/16.
 */
public class StrStr {

        public static int strStr( String haystack, String needle) {
            if (haystack.length() == 0 || needle.length() ==0) {
                return -1;
            }
            haystack = trim(haystack);
            needle = trim(needle);
            for (int i =0 ; i < haystack.length(); i++) {
                boolean innerLoop = false;
                for (int j=0; j < needle.length(); j++) {
                    if (haystack.charAt(i) != needle.charAt(j)) {
                        if (innerLoop) {
                            if (i <  haystack.length()-j-1) {
                                i = i -j;
                            }
                        }
                        break;
                    } else {
                        if (j== needle.length() -1) {
                            return i-j;
                        }
                        if (i < haystack.length()-1) {
                            innerLoop = true;
                            i++;
                        }  else {
                            return -1;
                        }
                    }
                }
            }
            return -1;
        }


        private static String trim(String input) {
            char[] inputArray = input.toCharArray();
            int index = 0;
            boolean startFound = false;
            for (int i = 0; i < input.length(); i++) {
                if (inputArray[i] != ' ' && !startFound) {
                    startFound = true;
                } else if (inputArray[i] == ' ' && startFound) {
                    inputArray[i] = '\0';
                    break;
                } else if (inputArray[i] == ' ') {
                    index++;
                }
            }
            for (int j = 0; j < inputArray.length - index; j++) {
                inputArray[j] = inputArray[j + index];
            }
            for (int j = inputArray.length - index; j < inputArray.length; j++)
                inputArray[j] = '\0';

            return String.valueOf(inputArray);
        }



}
