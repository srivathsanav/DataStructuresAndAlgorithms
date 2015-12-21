package com.interviewbit.assignment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by srivathsan on 16/11/15.
 */
public class MinWindow {

    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }
        Map<Character, Integer> characterMap = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (characterMap.get(T.charAt(i)) != null) {
                characterMap.put(T.charAt(i), characterMap.get(T.charAt(i)) + 1);
            } else {
                characterMap.put(T.charAt(i), 1);
            }
        }
        int minLength = Integer.MAX_VALUE;

        Map<Character, Integer> hasValueMap;

        int end = 0;
        int minStart = 0;
        int minEnd = 0;
        for (int start = 0; start < S.length(); start++) {
            int count = 0;
            hasValueMap = new HashMap<Character, Integer>();
            for (; end < S.length(); end++) {
                if (hasValueMap.get(S.charAt(end)) != null) {
                    hasValueMap.put(S.charAt(end), hasValueMap.get(S.charAt(end)) + 1);
                } else {
                    hasValueMap.put(S.charAt(end), 1);
                }

                if (characterMap.get(S.charAt(end)) != null) {
                    int value = characterMap.get(S.charAt(end));
                    if (hasValueMap.get(S.charAt(end)) <= value) {
                        count++;
                    }
                }
                int k = 0;
                if (count == T.length()) {
                    for ( k = start; k < end; k++) {
                        if (characterMap.get(S.charAt(k)) != null && hasValueMap.get(S.charAt(k)) > characterMap.get(S.charAt(k))) {
                            hasValueMap.put(S.charAt(k), hasValueMap.get(S.charAt(k)) - 1);
                        } else if (characterMap.get(S.charAt(k)) == null) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    start = k;
                    if (minLength > (end - start +1)) {
                        minLength = end - start +1 ;
                        minStart = start;
                        minEnd = end +1;
                    }
                }

            }
        }

        return  minLength == Integer.MAX_VALUE ? "" : S.substring(minStart, minEnd);
    }


    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("gegQ0SyEf0mUUd5fj8dT2og0i6OAS23iH2KcUkgFJznx99BUxlRZwRYlxR2XOumdC9B86v7SwhPGf9jLlBzVG4yWr528539Kme5CEZcABNr3rbzGpr76enhArjhlsnhHfRWs9xTzmPQLZpaw9yMVYZgevrWoIKiuKj89LQHqFWkddRxuehQNh2HrPuDLJTmUZvCfErufmrjjkOd9FKUbYpwrzZB8eoMIntpSzUXc8RaBmE3QCIQB16MXhMm4Q3TTSMC53cPDlAqCemD88cZNbS9wTMyqUuauQQKDZOpFYBmmHbJ6odrFw1jxWWrJTpm6Lf5ezr7mjJ9wrWlKtVIjHtIdBHZWE6P9xIgl7g4Z0RUKvbhE2RfzpuvcxQZOwoxueBjInfth3IQjqlEHaK03U5sYoeaku5porYAANaAAxuduQz8smMbbH15KlLBgbwR1L6s7jBygv395dh28u9Isog7DLM5Kg1WUvLYh7LMbfnvbQ7eBFENAbfLvFOxzzy8RhV4bsU1Z5qpjpGM0lzlPV6TiqXoJwY1HHpdKBjq3n9yabcQgXLcgNBu8p1e07oI8DRat3YQonX04EoOw6GU2OeeoVRMay5Q0YetVFpMLNs6D4Z4qB0ZDSAXF5Ll1nXGh7fvuzXBY4SAV9AhRnxLpJl2hcUT6irHal0QPe0OgzFAEL6Cc5sf3SwkUBLIwpqzXaTHD5IylNyvGVXmI0x6aHBtoTkosOX778umnaMrCwOG0MHmKmLBUOmxCtbDPPeWMwHstwaUjeTPrsLBMldEc9Wy4odN", "nNYbBKeom7CEqpy8O9eCuYwA"));
    }
}
