package com.interviewbit.assignment.arrays;

import java.util.ArrayList;

/**
 * Created by srivathsan on 14/01/16.
 */
public class Reach {

    // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int numSteps = 0;
        for(int i = 1; i < X.size(); i++){
            numSteps += Math.max( Math.abs(X.get(i) - X.get(i-1)), Math.abs(Y.get(i) - Y.get(i-1)) );
        }
        return numSteps;

    }
}
