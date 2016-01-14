package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 23/10/15.
 */
public class atoi {

    public static int atoi(final String a) {
        double val =0;
        int index = 0;
        for (index =0; index < a.length(); index++) {
            if (a.charAt(index) == ' ') {
                continue;
            } else if (!((a.charAt(index) -'0' <=9  && a.charAt(index) -'0' >=0) || a.charAt(index) =='-' ||  a.charAt(index) =='+' )) {
                return (int)val;
            } else if (a.charAt(index) != ' ') {
                break;
            }
        }
        boolean negative = false;
        if ( a.charAt(index) =='-') {
            negative = true;
            index++;
        } else if ( a.charAt(index) =='+') {
            negative = false;
            index++;
        }
        StringBuffer trueInput = new StringBuffer();
        boolean spaceFound = false;
        for ( int i = index; i < a.length(); i++)  {
            if (a.charAt(i) == ' ') {
                break;
            } else if (((a.charAt(i) -'0' <=9  && a.charAt(i) -'0' >=0))) {
                trueInput.append(a.charAt(i));
            } else {
                break;
            }
        }
        int base = 10;
         index = 0;

        for (int i = trueInput.toString().length() -1 ; i >=0; i--) {
              val = val + ( trueInput.charAt(i) - '0' ) * Math.pow(base,index ) ;
              index++;
        }
         if ((val >  Integer.MAX_VALUE || val < Integer.MIN_VALUE) && negative)  {
             return  Integer.MIN_VALUE;
         } else if ((val >  Integer.MAX_VALUE || val < Integer.MIN_VALUE) && !negative) {
            return  Integer.MAX_VALUE;
        }  else if (negative){
             val = -val;
         }
        return  (int)val;
    }

    public static void main(String[] args) {
        System.out.println(atoi("7"));
    }
}
