package com.interviewbit.assignment.HackerEarthProblems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by srivathsan on 18/11/15.
 */
public class Monk {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            ArrayList<Integer> numList = new ArrayList<Integer>();
            String[] numArray = br.readLine().split(" ");
            for (int i =0; i < numArray.length; i++) {
                numList.add(Integer.parseInt(numArray[i]));
            }


            System.out.println(findSpecial(numList));


        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private static int findSpecial(ArrayList<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();

        boolean oneFound = false;

        for (int i = list.size() -1; i >= 0; i--) {
            if (list.get(i) == 1) {
                if (!oneFound) {
                    oneFound = true;
                } else {
                    return list.size();
                }
            }
        }

        if (oneFound) {
            return list.size() -1;
        }
        int count = 0;
        for (int i =0; i < list.size(); i++) {
            if (map.get(list.get(i)) != null) {
                count++;
            } else {
                for (int j = i+1; j < list.size(); j++) {
                    if (i != j && list.get(i) % list.get(j) == 0) {
                        count++;
                        map.put(list.get(i), true);
                        break;
                    }
                }
            }

        }
        return count;
    }


}
