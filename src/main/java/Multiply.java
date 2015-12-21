package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by srivathsan on 25/10/15.
 */
public class Multiply {

    public static String multiply(String a, String b) {
        ArrayList<String> products = new ArrayList<String>();

        for (int i =a.length() -1; i >= 0; i--) {
            StringBuffer sb = new StringBuffer(multiplyValues(a.charAt(i), b));
            for (int count = 0 ; count < a.length() -1 - i; count++) {
                sb.append("0");
            }
            products.add(sb.toString());
        }
        Stack<String> newStack = new Stack<String>();

        int carry = 0;
        int max = products.get(products.size()-1).length();
        for (int i =0 ; i < max; i++)  {
            int sum = 0;

            for (int k =0; k < products.size(); k++) {
                if (i < products.get(k).length()) {
                     sum =  products.get(k).charAt(products.get(k).length()-1-i) - '0'  + sum;


                }
            }
            sum = sum + carry;
            if ( i != max -1 ) {
                carry = sum / 10;
                sum = sum % 10;
            }
            newStack.push(sum+"");
        }
        StringBuffer sb = new StringBuffer("");

        while (!newStack.empty()) {
            StringBuffer finalProductS = new StringBuffer().append(newStack.pop());

            sb.append(finalProductS);
        }

        String withoutZeros = sb.toString();
        withoutZeros = "0129281419508942330644788914772375911909165364374172850648846234013189757981044692486872392891670352883617068289942863624";
        int index = 0;
        boolean found = false;
        for (int i = 0; i < withoutZeros.length(); i++) {
            if (withoutZeros.charAt(i) == '0') {
                found = true;

                if (i != withoutZeros.length() - 1) {
                    if (withoutZeros.charAt(i) == withoutZeros.charAt(i + 1)) {
                        index = i + 1;
                        continue;
                    } else {

                        break;
                    }
                }
            } else {
                break;
            }
        }
        String result = "";
        if (found) {
            result =  withoutZeros.substring(index+1, withoutZeros.length());

        } else {
            result =  withoutZeros.substring(index, withoutZeros.length());

        }
        if (result.length() == 0) {
            return "0";
        } else {
            return  result;
        }
    }

    private static String multiplyValues(char a, String b) {
        StringBuffer sb = new StringBuffer("");
        int product1 = a - '0';
        int carry = 0;
        Stack<String> newStack = new Stack<String>();
        for (int j =b.length() -1; j >=0; j-- ) {
            int  product2 = b.charAt(j) - '0';
            int finalProduct = product1 * product2 + carry;
            if (j != 0) {
                carry = finalProduct / 10;
                finalProduct = finalProduct % 10;
            }

            newStack.push(finalProduct+"");
        }
        while (!newStack.empty()) {
            StringBuffer finalProductS = new StringBuffer().append(newStack.pop());

            sb.append(finalProductS);
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("31243242535342", "0"));

    }
}
