package com.interviewbit.assignment;

/**
 * Created by srivathsan on 23/10/15.
 */
public class ValidNumber {

    public static int isNumber(final String a) {
        int index = 0;
        for (index =0; index < a.length(); index++) {
            if (a.charAt(index) == ' ') {
                continue;
            } else if (!((a.charAt(index) -'0' <=9  && a.charAt(index) -'0' >=0) || a.charAt(index) =='-' ||  a.charAt(index) =='+' ||  a.charAt(index) =='.')) {
                return 0;
            } else if (a.charAt(index) != ' ') {
                break;
            }
        }
        if (index == a.length()) {
            index--;
        }
        if ( a.charAt(index) =='-') {
            index++;
        } else if ( a.charAt(index) =='+') {
            index++;
        }
        boolean numberFound = false;
        int dotIndex = -1;
        int eIndex = -1;
        for ( int i = index; i < a.length(); i++)  {
            if (a.charAt(i) == '.' ) {
                if (i == a.length()-1) {
                    return 0;
                } else if (dotIndex != -1) {
                    return  0;
                } else if (eIndex != -1) {
                    return  0;
                } else {
                    dotIndex = i;
                }

            } else if (a.charAt(i) == ' ' ) {
                if (i != a.length()-1) {
                    if (a.charAt(i+1) != ' ') {
                        return  0;
                    }
                }
            } else if (a.charAt(i) == 'e' ) {
                if (i == a.length()-1 || i ==0) {
                    return 0;
                } else if (eIndex != -1 ) {
                    return 0;
                }else if (i != a.length() -1  && (!(a.charAt(i+1) == '-' || ((a.charAt(i+1) -'0' <=9  && a.charAt(i+1) -'0' >=0))))) {

                        return 0;
                    } else if (i != 0  && (!(((a.charAt(i-1) -'0' <=9  && a.charAt(i-1) -'0' >=0))))) {
                            return 0;

                }   else {
                        eIndex = i;
                    }



            } else if (a.charAt(i) == '-') {
                if (eIndex != i-1) {
                    return  0;
                }
            }
            else if (!((a.charAt(i) -'0' <=9  && a.charAt(i) -'0' >=0))) {
                return  0;

            }  else {
                numberFound = true;
            }
        }
        if (!numberFound) {
            return  0;
        }
        return  1;
    }
    public static void main(String[] args) {




        System.out.println(isNumber(" 123e-10"));
        System.out.println(isNumber(" 123.e10"));


        System.out.println(isNumber(" 123e10"));
        System.out.println(isNumber(" 123.e-10"));



        System.out.println(isNumber(".123e"));
        System.out.println(isNumber(" 123e"));
        System.out.println(isNumber(" 123 e "));
        System.out.println(isNumber(" 123e+1 "));

        System.out.println(isNumber(" 123e10e"));
        System.out.println(isNumber(" e10e"));

        System.out.println(("**************"));





        System.out.println(isNumber("123"));
        System.out.println(isNumber("+123"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("  +123"));
        System.out.println(isNumber("  -123"));
        System.out.println(isNumber("  -123  "));
        System.out.println(isNumber("  -123+  "));
        System.out.println(isNumber("  +-123  "));
        System.out.println(isNumber("  *123  "));
        System.out.println(isNumber("  +1 23  "));
        System.out.println(isNumber("  +1 a3  "));
        System.out.println(isNumber("abc"));
        System.out.println(isNumber(".abc"));

        System.out.println(isNumber(".123"));
        System.out.println(isNumber(" 1.123"));
        System.out.println(isNumber(" 1.1.23"));
        System.out.println(isNumber(" 1.1.23."));
        System.out.println(isNumber(" 1123.0"));
        System.out.println(isNumber(" 1123.0f"));



























    }

}
