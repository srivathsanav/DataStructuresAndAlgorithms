package com.interviewbit.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by srivathsan on 02/11/15.
 */
public class SimplifyPath {
    public static String simplifyPath(String a) {
        Stack<String> path = new Stack<String>();
        StringBuffer sb = new StringBuffer();

        for (int i =0; i < a.length(); i++) {

            if (a.charAt(i) != '/') {
                sb.append(a.charAt(i));


            } else if (a.charAt(i) == '/'){
                  if (sb.toString().length() > 0) {
                      if (sb.toString().equals("..")) {
                          if (path.size() > 0) {
                              path.pop();
                          }
                      } else if (sb.toString().equals(".")) {

                      } else {
                          path.push(sb.toString());
                      }
                      sb = new StringBuffer();
                  }
            }
        }

        if (sb.toString().length() > 0) {
            if (sb.toString().equals("..")) {
                if (path.size() > 0) {
                    path.pop();
                }
            } else if (sb.toString().equals(".")) {

            } else {
                path.push(sb.toString());
            }
            sb = new StringBuffer();
        }
        List<String> pathList = new ArrayList<String>();
        while (!path.empty()) {
              pathList.add(path.pop());
        }
        Collections.reverse(pathList);
        StringBuffer finalPath = new StringBuffer();

        for (int i =0; i < pathList.size(); i++) {
            finalPath.append("/") ;
            finalPath.append(pathList.get(i));




        }








        return finalPath.toString().length() > 0 ? finalPath.toString() : "/";
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("//a//b/c/./.."));
    }
}
