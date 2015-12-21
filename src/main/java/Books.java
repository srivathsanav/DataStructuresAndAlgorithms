package com.interviewbit.assignment;

    import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by srivathsan on 20/10/15.
 */
public class Books {

    public static int books(ArrayList<Integer> A, int B) {
        long result = 0;
        int students = B;
        int noOfBooks = A.size();
        if (A.size() < students) {
            return  -1;
        }
        long low = 0;
        long high = Long.MAX_VALUE;
        int sum = 0;
        for (int i =0; i < A.size() ; i++) {
            sum = sum + A.get(i);
        }

        while (low <= high)  {
            long mid = (low + high) /2;
            if (isPossible(A, students, mid, sum)) {
                result = mid;
                high =  mid -1;
            } else {
                low = mid +1;
            }
        }
        return (int)result;
    }

    private static boolean isPossible(ArrayList<Integer> A, int students, long maxPageForStudent, long totalPagesInBook) {
            if (maxPageForStudent < totalPagesInBook / students )
                return  false;
            int index = 0;
            for (int i =0; i < students && index < A.size() ; i++)  {
                int total = 0;
                while (total < maxPageForStudent && index < A.size()) {

                    total = total + A.get(index);
                    if (total > maxPageForStudent) {
                        break;
                    }
                    index ++;
                }

            }
        if (index < A.size() ) {
            return false;
        }
          return  true;
    }


    public static void main(String[] args) {
        System.out.println(books(new ArrayList<Integer>(Arrays.asList(87, 3, 27, 29, 40, 12, 3, 69, 9, 57, 60, 33, 99)), 5));
    }
}
