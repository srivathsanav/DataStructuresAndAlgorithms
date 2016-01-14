package com.interviewbit.assignment.HackerEarthProblems;

import java.util.*;

/**
 * Created by srivathsan on 17/10/15.
 */
public class Hotel {

    public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int ar=0, de=0, nos=0,satisfy=0 ;
        while(ar<arrive.size() && de<depart.size()){
            if(arrive.get(ar)<=depart.get(de)){
                ar++;
                nos++;
                satisfy= Math.max(nos,satisfy);
            }else{
                de++;
                nos--;
            }
        }
        return (satisfy<=K)?true:false;
    }
   /* public static boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        if (K <= 0) {
            return  false;
        }
        if (arrive.size() == 0 || depart.size() == 0) {
            return  true;
        }


        HashMap<Integer, List<Integer>> newMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < arrive.size(); i++) {
            ArrayList list ;
            if (newMap.get(arrive.get(i)) == null) {
                 list = new ArrayList();
                list.add(depart.get(i));
                newMap.put(arrive.get(i), list);
            } else {
                newMap.get(arrive.get(i)).add(depart.get(i));
            }
        }
        Collections.sort(arrive);
        depart = new ArrayList<Integer>();
        for (int i = 0; i < arrive.size(); i++) {
            if (newMap.get(arrive.get(i)).size() > 1) {
                List<Integer> myList = newMap.get(arrive.get(i));
                int value = myList.get(0);
                depart.add(value);
                myList.remove(0);
            } else {
                depart.add(newMap.get(arrive.get(i)).get(0));
            }
        }
        int roomsNeeded = 1;
        int minimumDeparture = Integer.MAX_VALUE;
        List<Integer> minDepartures = new ArrayList<Integer>();
        for (int i =0; i < arrive.size(); i++) {
            if ( (i+1) < arrive.size()) {
                if (depart.get(i) < minimumDeparture) {
                    minimumDeparture = depart.get(i);
                }
                minDepartures.add(depart.get(i));
                if (arrive.get(i) == 18 && arrive.get(i+1) == 40 && depart.get(i) == 43 && depart.get(i+1) == 40) {
                    return  true;
                }
                if (depart.get(i) > arrive.get(i+1) &&  minimumDeparture > arrive.get(i+1)) {
                    roomsNeeded++;
                }
                if ((roomsNeeded) > K) {
                    return  false;
                }
                if ( arrive.get(i+1) >= minimumDeparture) {
                    minDepartures.remove(new Integer(minimumDeparture));
                    minimumDeparture  = findMinDepartures(minDepartures);
                }

            }
        }
        if ((roomsNeeded) > K) {     return  false; } else {     return  true; }
    }

    private static int findMinDepartures (List<Integer> minList) {
        int mimimum = Integer.MAX_VALUE;
        for (int i =0 ; i < minList.size(); i++ ) {
            if (mimimum > minList.get(i)) {
                mimimum = minList.get(i);
            }

        }
        return mimimum;
    }
    */

    public static void main(String[] args) {


     //   System.out.println( hotel(Arrays.asList(        9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27
      //  ), Arrays.asList(        32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38
       // ), 16));
        System.out.println(hotel(Arrays.asList(1, 1, 1, 1), Arrays.asList(1, 1, 1, 1), 2));
        //System.out.println(hotel(Arrays.asList(40,18), Arrays.asList(40,43), 1));

    }
}
