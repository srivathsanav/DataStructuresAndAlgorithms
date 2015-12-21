package com.interviewbit.assignment;

import java.util.*;

/**
 * Created by srivathsan on 13/10/15.
 */
public class Anagrams {

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> anagrams = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0 ;i < a.size() ; i++) {
            int hash = calculateHash(a.get(i));
            ArrayList<Integer> values ;
            if (map.get(hash) == null) {
                values = new ArrayList<Integer>();
                values.add(i+1);
                map.put(hash, values);
            } else {
                map.get(hash).add(i+1);
            }

        }
       for (Map.Entry<Integer, ArrayList<Integer>>  entry : map.entrySet()) {
               anagrams.add(entry.getValue());

        }
        return  anagrams;
    }


    private static int calculateHash(String a) {
        int hashValue = 0;
        for (int i = 0 ; i < a.length(); i++) {
            hashValue = hashValue + (int)a.charAt(i);
        }
        return  hashValue;
    }

    public static void main(String[] args) {

        System.out.println(anagrams(Arrays.asList("abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb")));
    }
}
