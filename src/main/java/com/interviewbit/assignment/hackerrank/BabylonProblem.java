package com.interviewbit.assignment.hackerrank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by srivathsan on 10/16/17.
 */
public class BabylonProblem {

    static class Result {
        int countryId;
        int surveyRanking;

        public Result(int countryId, int surveyRanking) {
            this.countryId = countryId;
            this.surveyRanking = surveyRanking;
        }
    }

    private static int findCountryWithLeastSurveyRanking(int[] countrySurveyRanking, int statesInCountry, boolean[] alreadyTaken) {
        int minimum = Integer.MAX_VALUE;
        int minCountryIndex = -1;
        for (int i = 0; i < countrySurveyRanking.length; i++) {
            if (!alreadyTaken[i] && countrySurveyRanking[i] < minimum) {
                minimum = countrySurveyRanking[i];
                minCountryIndex = i/statesInCountry;
            }
        }
        return  minCountryIndex;
    }


    private static Result surveyStates(int surveyListLength, int statesInCountry, int monthNumber, int[] countrySurveyRanking) {
        Result result = null;
        int numberOfCountries = surveyListLength/statesInCountry;
        boolean[] alreadyTaken = new boolean[countrySurveyRanking.length];
        List<Integer> currentSublist = new ArrayList<>();
        int countryIndex = getCountryIndex(statesInCountry, countrySurveyRanking, alreadyTaken, currentSublist);
        int count = 0;
        while (monthNumber > 0) {
            monthNumber--;
            if (count == statesInCountry) {
                count = 0;
                currentSublist = new ArrayList<>();
                countryIndex = getCountryIndex(statesInCountry, countrySurveyRanking, alreadyTaken, currentSublist);
            }
            if (monthNumber == 0) {
                int surveyRanking = currentSublist.get(count);
                int currentCountryIndex = countryIndex + 1;
                return new Result(countryIndex, surveyRanking);
            }
            count++;
        }
        return result;
    }

    private static int getCountryIndex(int statesInCountry, int[] countrySurveyRanking, boolean[] alreadyTaken, List<Integer> currentSublist) {
        int countryIndex = findCountryWithLeastSurveyRanking(countrySurveyRanking, statesInCountry, alreadyTaken);
        for (int i = countryIndex * statesInCountry; i < (countryIndex * statesInCountry) + statesInCountry; i++) {
            currentSublist.add(countrySurveyRanking[i]);
            alreadyTaken[i] = true;
        }
        Collections.sort(currentSublist);
        return countryIndex;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 7, 9, 3, 2, 5, 1, 3, 2, 4, 1};
        Result result = surveyStates(12, 3, 7, arr);
        System.out.println(result.countryId + "   " + result.surveyRanking);
    }

}
