package com.interviewbit.assignment.HackerEarthProblems;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 16/10/15.
 */
public class NextPermutation {

    public static void nextPermutation(List<Integer> a) {
        if (a.size() == 0) {
            return;
        }
        int k = -1;
        for (int i = a.size() -1 ; i >= 1; i --) {
           if (a.get(i) > a.get(i-1)) {
               k = i-1;
               break;
           }
        }
        if (k == -1) {
            reverse(a, -1);
            return;
        } else {
            int l = -1;
            for (int i= a.size() -1; i >k ; i--) {
                if (a.get(i) > a.get(k)) {
                    l = i;
                    break;
                }
            }

            //swap
            int temp = a.get(k);
            a.set(k, a.get(l));
            a.set(l, temp);
            reverse(a,k);

        }


    }

    private static  void reverse(List<Integer> a,int k) {
        int n = a.size();
        for (int i = 0; i < (n-k)/2 ; i++) {
            int temp = a.get(i+k+1);
            a.set(i+k+1, a.get(n-i-1));
            a.set(n-i-1, temp);
        }
    }

    public static void main(String[] args) {
      //  List<Integer> a = Arrays.asList(444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788, 609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84, 460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265, 315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422, 363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 );
        List<Integer> a = Arrays.asList(701, 319, 695, 52);
        nextPermutation(a);
        System.out.println(a);
    }
}
