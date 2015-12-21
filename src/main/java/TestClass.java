package com.interviewbit.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by srivathsan on 18/11/15.
 */
public class TestClass {


    public static void main(String[] args) {

      try {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          String line = br.readLine();
          int N = Integer.parseInt(line);
          List<String> anagramList = new ArrayList<String>();
          for (int i = 0; i < N; i++) {
              String[] anagramArray = br.readLine().split(" ");
              anagramList.add(anagramArray[0]);
              anagramList.add(anagramArray[1]);
          }

          TestClass testClass =  new TestClass();
          for (int i =0; i < anagramList.size() ; i++)  {
              if(testClass.isAnagram(anagramList.get(i), anagramList.get(++i))) {
                  System.out.println("YES");
              } else {
                  System.out.println("NO");
              }
          }

      } catch (IOException ex) {
          System.out.println(ex);
      }
    }


    boolean isAnagram (String one, String two)  {

        if (one.length() != two.length())
            return false;

       // HashMap<Character,Boolean> anagramMap = new HashMap<Character, Boolean>();
        char[] firstCharArray = one.toCharArray();
        char[] secondCharArray = two.toCharArray();
        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);
        one = String.valueOf(firstCharArray);
        two = String.valueOf(secondCharArray);
        return one.equals(two);

    }
}
