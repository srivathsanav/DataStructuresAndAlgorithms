package com.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srivathsan on 22/03/17.
 */
public class RotatedMatrix {
        public static int searchMatrix(List<ArrayList<Integer>> matrix, int b) {

            int n = matrix.size();
            int m = matrix.get(0).size();
            int l = 0, r = m * n - 1;
            while (l != r){
                int mid = (l + r - 1) >> 1;
                if ( matrix.get(mid/m).get(mid%m) < b)
                    l = mid + 1;
                else
                    r = mid;
            }
            return  matrix.get(r/m).get(r%m) == b ? 1 : 0;
        }




}
