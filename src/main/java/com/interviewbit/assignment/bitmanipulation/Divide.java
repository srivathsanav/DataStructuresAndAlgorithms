package com.interviewbit.assignment.bitmanipulation;

/**
 * Created by srivathsan on 24/10/15.
 */
public class Divide {
     String Divide(String N, int data) {
         N =new StringBuffer(N).reverse().toString();
        double base = 10;
        String temp = "";
         double rem = 0;
        for(int i = (int)N.length() - 1; i >= 0; --i) {
            double Cur = (N.charAt(i) - '0') + rem * base;
            double val  = (Cur / data);
            rem = Cur % data;
            temp += (val + '0');
        }
         //while(temp.length() > 0 && (temp.charAt(0 - '0') != 0))
            //temp.erase(temp.begin());

        return temp;
    }


    public static void main(String[] args) {

    }
}
