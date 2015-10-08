package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 08/10/15.
 */

public class SetZero {
    public void setZeroes(ArrayList<ArrayList<Integer>> A) {
        int m, n;

        if (A == null)
            return;

        m = A.size();
        n = A.get(0).size();

        if (n == 0)
            return;

        for (int i = 0; i < m; i++) {
            boolean zero = false;
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 0)
                    zero = true;
            }

            if (zero)
                clearRow(A, i, m, n, 2);

        }

        for (int i = 0; i < n; i++) {
            boolean zero = false;
            for (int j = 0; j < m; j++) {
                if (A.get(j).get(i) == 0)
                    zero = true;
            }

            if (zero)
                clearCol(A, i, m, n, 2);

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A.get(i).get(j) == 2)
                    A.get(i).set(j, 0);
            }
        }

    }


    public void clearRow(ArrayList<ArrayList<Integer>> A, int row, int m, int n, int value) {

        for (int i = 0; i < n; i++) {
            if (A.get(row).get(i) == 1)
                A.get(row).set(i, value);
        }
    }

    public void clearCol(ArrayList<ArrayList<Integer>> A, int col, int m, int n, int value) {
        for (int i = 0; i < m; i++) {
            if (A.get(i).get(col) == 1)
                A.get(i).set(col, value);
        }
    }

}
