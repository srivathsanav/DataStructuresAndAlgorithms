import java.util.Arrays;

/**
 * Created by srivathsan on 10/15/17.
 */
public class UserMainCode {

  public static class Result {
      public  int output1;
      public int output2;
  }

  public static Result Survey(int input1, int input2, int input3, int[] input4) {

      int totalNoofCountries = input4.length/input2;

      // Construct countryWithLeastRating array
      CountryStateSurveyMapping[] countryWithLeastRating = new CountryStateSurveyMapping[totalNoofCountries];
      for (int i =0; i < totalNoofCountries; i++) {
          int surveyRating = Integer.MAX_VALUE;
          for (int j =  i * input2; j < (i * input2) + input2; j++) {
              if ( input4[j] < surveyRating) {
                  surveyRating = input4[j];
              }
          }
          countryWithLeastRating[i] = new CountryStateSurveyMapping(i, surveyRating);
      }

      // Sort countryWithLeastRating;
      Arrays.sort(countryWithLeastRating);

      // Find  index
      int index = input3/input2;
      // find the element available in the country index
      if (index == totalNoofCountries) {
          index--;
      }
      int countryIndex = countryWithLeastRating[index].countryId;

      int monthToFind = input3%input2;
      int[] candidateSurveyArr = new int[input1];
      int count = 0;
      for (int i = countryIndex * input2; i < (countryIndex * input2 + input2); i++) {
          candidateSurveyArr[count++] = input4[i];
      }

      // Find in candidateSurveyArr the correspodning month
      Arrays.sort(candidateSurveyArr);


      return new Result();

  }



  static class CountryStateSurveyMapping implements  Comparable<CountryStateSurveyMapping> {
      int countryId;
      int leastSurveyRating;
      //int[] stateSurveyRatings (Include this when there is match in leastSurveyRating

      public CountryStateSurveyMapping(int countryId, int leastSurveyRating) {
          this.countryId = countryId;
          this.leastSurveyRating = leastSurveyRating;
      }

      @Override
      public int compareTo(CountryStateSurveyMapping o) {
          int surveyRating = Integer.compare(leastSurveyRating, o.leastSurveyRating);
          if (surveyRating != 0) {
              return surveyRating;
          }
          return surveyRating;
      }
  }


    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 3, 1, 4};
        Survey(6, 3, 6, arr);
    }
}
