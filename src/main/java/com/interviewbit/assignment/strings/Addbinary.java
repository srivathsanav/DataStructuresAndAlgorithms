package com.interviewbit.assignment.strings;

/**
 * Created by srivathsan on 23/10/15.
 */
public class Addbinary {

    public static String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
         int aIndex = a.length() - 1;
        int  bIndex = b.length() - 1;
        int carry = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            int aIndexValue = Integer.valueOf(a.charAt(aIndex)) - Integer.valueOf('0');
            int bIndexValue = Integer.valueOf(b.charAt(bIndex)) - Integer.valueOf('0');
            int finalSum = aIndexValue + bIndexValue + carry ;
            if (finalSum <= 1) {
                result.append(finalSum);
                carry = 0;
            } else if (finalSum == 2) {
                result.append(0);
                carry = 1;
            }  else if (finalSum == 3) {
                result.append(1);
                carry = 1;
            }
            finalSum = 0;
            aIndex--; bIndex--;
        }

        while (aIndex >= 0) {
            int aIndexValue = Integer.valueOf(a.charAt(aIndex)) - Integer.valueOf('0');
            if (carry == 1) {
                int finalSum = aIndexValue + carry;
                if (finalSum <= 1) {
                    result.append(finalSum);
                    carry = 0;
                } else if (finalSum == 2) {
                    result.append(0);
                    carry = 1;
                }
                finalSum = 0;
            } else {
                result.append(aIndexValue);
            }
            aIndex--;
        }

        while (bIndex >= 0) {
            int bIndexValue = Integer.valueOf(b.charAt(bIndex)) - Integer.valueOf('0');
            if (carry == 1) {
                int finalSum = bIndexValue + carry;
                if (finalSum <= 1) {
                    result.append(finalSum);
                    carry = 0;
                } else if (finalSum == 2) {
                    result.append(0);
                    carry = 1;
                }
                finalSum = 0;
            } else {
                result.append(bIndexValue);
            }
            bIndex--;
        }
        if (carry ==1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
        System.out.println("1001110001111010101001110".equals("1001110001111010101001110"));

    }


}


