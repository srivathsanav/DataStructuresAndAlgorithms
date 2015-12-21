package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 06/11/15.
 */
public class EqualsHashing {


    public  ArrayList<Integer> equal(ArrayList<Integer> a) {
        if (a.size() < 4) {
            return new ArrayList<Integer>();
        }
        HashMap<Integer,List<NumberVal>> map = new HashMap<Integer, List<NumberVal>>();


        int firstIndex = Integer.MAX_VALUE;
        int secondIndex = Integer.MAX_VALUE;
        int thirdIndex = Integer.MAX_VALUE;
        int fourthIndex = Integer.MAX_VALUE;
        List<NumberVal> numList;

        for (int j =0 ; j < a.size(); j++) {

            for (int i = j + 1; i < a.size(); i++) {
                if (map.get(a.get(i)+a.get(j)) != null) {
                    List<NumberVal> list = map.get(a.get(i)+a.get(j));
                    for (NumberVal value : list) {
                        if (isValid(value, j, i) && isMinimal(firstIndex, secondIndex, thirdIndex, fourthIndex, value, j, i)) {
                            firstIndex = value.firstIndex;
                            secondIndex = value.secondindex;
                            thirdIndex = j;
                            fourthIndex = i;
                        }
                    }
                    list.add(new NumberVal(j,i));
                } else {
                    numList = new ArrayList<NumberVal>();
                    numList.add(new NumberVal(j, i));
                    map.put(a.get(i) + a.get(j), numList);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(firstIndex);
        result.add(secondIndex);
        result.add(thirdIndex);
        result.add(fourthIndex);
        return firstIndex == Integer.MAX_VALUE ? new ArrayList() : result;


    }

    private static boolean isMinimal(int firstIndex, int secondIndex, int thirdIndex, int fourthIndex, NumberVal val, int i, int j) {
        if (val.firstIndex < firstIndex) {
            return true;
        } else if (val.firstIndex == firstIndex) {
            if (val.secondindex < secondIndex) {
                return true;
            } else if (val.secondindex == secondIndex) {
                if ( i < thirdIndex) {
                    return true;
                } else if (i == thirdIndex) {
                    if (j < fourthIndex) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private static boolean isValid (NumberVal val, int thirdIndex, int lastIndex) {
        if (val.firstIndex >= val.secondindex) {
            return false;
        } else if (val.firstIndex >= thirdIndex) {
            return  false;
        } else if (thirdIndex >= lastIndex) {
            return false;
        } else if (val.secondindex == thirdIndex) {
            return false;
        } else if (val.secondindex == lastIndex) {
            return false;
        }

        return  true;
    }


     class NumberVal {
        int firstIndex;
        int secondindex;

        public NumberVal(int firstIndex, int secondindex) {
            this.firstIndex = firstIndex;
            this.secondindex = secondindex;
        }

        public int getFirstIndex() {
            return firstIndex;
        }

        public int getSecondindex() {
            return secondindex;
        }

    }

    public static void main(String[] args) {
      //  System.out.println(new EqualsHashing().equal(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 2, 1, 0))));
        System.out.println(new EqualsHashing().equal(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1))));

    }

}
