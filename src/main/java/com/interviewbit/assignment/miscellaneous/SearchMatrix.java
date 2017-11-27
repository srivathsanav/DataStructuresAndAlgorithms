package com.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 02/01/17.
 */
public class SearchMatrix {



    private static int findRowIndex (List<ArrayList<Integer>> a, int b) {
        int high = a.size()-1;
        int size = a.get(0).size() - 1;

        int low = 0;
        while (low <= high) {
            int mid = (low + high) /2;
            if (a.get(mid).get(size) <= b) {
                high = mid - 1;
            } else  if (a.get(mid).get(size) > b) {
                low = mid + 1;
            }
        }
        return low - 1;
    }


    private static int findColumnIndex (List<ArrayList<Integer>> a, int b, int rowIndex) {
        int high = a.get(rowIndex).size() - 1;
        int size = a.get(0).size() - 1;

        int low = 0;
        while (low <= high) {
            int mid = (low + high) /2;
            if (a.get(rowIndex).get(mid) < b) {
                high = mid - 1;
            } else  if (a.get(rowIndex).get(mid) > b) {
                low = mid + 1;
            }
        }
        return low - 1;
    }


    public static void main(String[] args) {

    }

}
