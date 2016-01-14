package com.interviewbit.assignment.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by srivathsan on 05/11/15.
 */
public class ValidSudoku {
    public static int isValidSudoku(final List<String> a) {
        if (a.size() > 9) {
            return 0;
        }
        int[][] sudokoMatrix = new int[9][9];

        for (int i =0; i < a.size(); i++) {
            char[] row = a.get(i).toCharArray();
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '.') {
                    sudokoMatrix[i][j] = Integer.MAX_VALUE;
                } else {
                    int value = row[j] - 48;
                    sudokoMatrix[i][j] = value;
                }
            }
        }

        ArrayList<HashMap<Integer, Boolean>> gridList =  null;

        ArrayList<HashMap<Integer, Boolean>> columList = new ArrayList<HashMap<Integer, Boolean>>();


        HashMap<Integer, Boolean> gridMap = null;
        int count = 0;

        for (int i =0; i < sudokoMatrix.length; i++) {
            if ( i %3 == 0) {
                gridList =  new ArrayList<HashMap<Integer, Boolean>>();
            }
            HashMap<Integer, Boolean> rowMap = new HashMap<Integer, Boolean>();

            for (int j = 0; j < sudokoMatrix.length; j++) {

                int valid = isValidNumber(sudokoMatrix[i][j] ,rowMap);

                if (valid == 0) {
                    return  0;
                }
                if (columList.size() -1 < j ) {
                    HashMap<Integer, Boolean> columnMap = new HashMap<Integer, Boolean>();
                    columList.add(columnMap);
                }

                valid = isValidNumber(sudokoMatrix[i][j], columList.get(j));

                if (valid == 0) {
                    return  0;
                }

                if (i%3 == 0 && j%3 == 0) {
                    gridMap = new HashMap<Integer, Boolean>();
                    gridList.add(gridMap);
                }
                valid = isValidNumber(sudokoMatrix[i][j], gridList.get(j/3));

                if (valid == 0) {
                    return  0;
                }
                count++;



            }

        }


        return  1;

    }

    private static Integer isValidNumber(int value, HashMap<Integer, Boolean> map) {

        if (value == Integer.MAX_VALUE) {
            return 1;
        } else {
            if (value >=1 && value <= 9) {
                if (map.get(value) != null) {
                    return  0;
                } else {
                    map.put(value , true);
                }
            } else {
                return  0;
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(isValidSudoku(Arrays.asList("....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......")));
    }
}
