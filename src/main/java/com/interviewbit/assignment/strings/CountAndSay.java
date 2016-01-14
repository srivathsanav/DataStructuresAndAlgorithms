package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 14/01/16.
 */
public class CountAndSay {

    public static String countAndSay(int a) {
        if (a <= 0) {
            return "";
        }
        String temp = "1";
        for (int i = 1; i < a; i++) {
            temp = count(String.valueOf(temp));
        }
        return temp;
    }
    private static String countOneSeqence(String sequence) {
        char[] seqArrray = sequence.toCharArray();
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for (int i = 0; i < seqArrray.length; i++) {
            count++;
        }
        sb.append(count).append(seqArrray[0]);
        return sb.toString();
    }

    private static String count(String sequence) {
        char[] seqArrray = sequence.toCharArray();
        StringBuffer finalBuffer = new StringBuffer();
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < seqArrray.length; i++) {
            startIndex = i;
            endIndex = i;
            for (int j = i + 1; j < seqArrray.length; j++) {

                if (seqArrray[i] != seqArrray[j]) {
                    endIndex = j - 1;
                    i = j;
                    break;
                }
                endIndex++;
            }
            if (startIndex >= 0 && endIndex >= 0) {
                StringBuffer intermediate = new StringBuffer();
                for (int k = startIndex; k <= endIndex; k++) {
                    intermediate.append(seqArrray[k]);
                }
                finalBuffer.append(countOneSeqence(intermediate.toString()));
                i = endIndex;
            }
        }

        return finalBuffer.toString();
    }
}
