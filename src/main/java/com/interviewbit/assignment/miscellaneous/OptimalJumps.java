package com.datastructures;

import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 04/03/17.
 */
public class OptimalJumps {

    private static int findMinJumps(List<Integer> jumpList) {
        int last = jumpList.size() - 1;
        int min = Integer.MAX_VALUE;
        int currentJumpIndex = 0;
        int noOfJump[] = new int[jumpList.size()];
        for (int i = 0; i < jumpList.size() - 1; i++) {
            currentJumpIndex = i;
            int count = noOfJump[i];

            while (currentJumpIndex < last) {
                currentJumpIndex = currentJumpIndex + jumpList.get(currentJumpIndex);
                count++;
            }
            if (currentJumpIndex == last) {
                if (count < min) {
                    min = count;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findMinJumps(Arrays.asList(2, 3, 1 , 1, 2, 4, 2, 0, 1 , 1)));
    }
}
