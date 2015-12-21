package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srivathsan on 06/11/15.
 */
public class LsZero {


    public ArrayList<Integer> lszero(ArrayList<Integer> a) {


        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int sum = 0;
        for (int i =0; i < a.size(); i++) {
            sum = sum + a.get(i);
            ArrayList<Integer> list = null;
            if (map.get(sum) == null) {
                list = new ArrayList<Integer>();
                list.add(i);
            } else {
                list = map.get(sum);
                list.add(i);
            }
            map.put(sum , list);
        }


        int minfromIndex = Integer.MAX_VALUE;
        int maxtoIndex = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;
        int length = 0;
        for (Map.Entry<Integer,ArrayList<Integer>>  keyVals: map.entrySet()) {
            if (keyVals.getKey() == 0) {
                length = keyVals.getValue().get(keyVals.getValue().size() -1) - 0;

                if (length > maxLength ) {
                    minfromIndex = -1;
                    maxtoIndex = keyVals.getValue().get(keyVals.getValue().size() -1);
                    maxLength = length;
                }
            } else if (keyVals.getValue().size() > 1) {
                ArrayList<Integer> values = keyVals.getValue();
                int fromIndex = 0;
                int toIndex = 0;
                if (values.size() >=2 ) {
                    fromIndex = values.get(0);
                    toIndex = values.get(values.size()-1);
                   }
                    if (keyVals.getKey() == 0) {
                        if (toIndex == a.size() -1) {
                            minfromIndex = -1;
                            maxtoIndex = a.size() -1;
                            break;
                        }
                    }
                     length = toIndex - fromIndex -1;


                    if (length > maxLength ) {
                        minfromIndex = fromIndex;
                        maxtoIndex = toIndex;
                        maxLength = length;
                    } else if (length == maxLength && fromIndex < minfromIndex) {
                        minfromIndex = fromIndex;
                        maxtoIndex = toIndex;
                    }



            }
        }
        if (maxtoIndex == Integer.MIN_VALUE) {
            return new ArrayList<Integer>();
        }

        if (maxtoIndex != a.size()  ) {
            maxtoIndex = maxtoIndex +1;
        }

        a =   new ArrayList<Integer>(a.subList(minfromIndex+1, maxtoIndex));
        return  a;
    }


    public static void main(String[] args) {
        System.out.println(new LsZero().lszero(new ArrayList<Integer>(Arrays.asList(22, -7, 15, -21, -20, -8, 16, -20, 5, 2, -15, -24, 19, 25, 3, 23, 18, 0, 16, 26, 13, 4, -20, -13, -25, -2 ))));
        System.out.println(new LsZero().lszero(new ArrayList<Integer>(Arrays.asList( -1, 20, 7, -22, 1, 21, 5, 24, -26, -16, -4, -9, 19, 8, -27, 28, 9, 8, -29, 29, 8, 9, 17, -28, 13, 20, -1, -8, -16))));
        System.out.println(new LsZero().lszero(new ArrayList<Integer>(Arrays.asList(0,1 ))));

    }
}
