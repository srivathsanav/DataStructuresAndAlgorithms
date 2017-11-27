import java.util.Scanner;

/**
 * Created by srivathsan on 10/6/17.
 */
public class Topic {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grades = new String[n];
        int topics = in.nextInt();
        for(int grades_i=0; grades_i < n; grades_i++){
            String out = in.next();
            //System.out.println(out);
            grades[grades_i] = out;
          //  System.out.println(grades[grades_i]);
        }
        teamAlgo1(grades, topics);
    }

    private static void teamAlgo1(String[] teams, int topics) {
        int maxCount = 0;
        int[] countMatrix = new int[topics];
        for (int i = 0; i < teams.length; i++) {
            for (int j = i+1; j < teams.length; j++) {
                int topic = 0;
                int count = 0;
                    while (topic < topics) {
                    if (teams[i].charAt(topic) == '1' || teams[j].charAt(topic) == '1') {
                        count++;
                    }
                    topic++;
                }
                if (count >= maxCount) {
                    maxCount = count;
                    countMatrix[i] = maxCount;
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < countMatrix.length; i++) {
            if (countMatrix[i] == maxCount) {
                counter++;
            }
        }
        System.out.println(maxCount);
        System.out.println(counter);
    }

    private static void teamAlgo(String[] teams, int topics) {
        int maxCount = 0;
        int counter = 0;
        int[] countMatrix = new int[topics];
        for (int i = 0; i < teams.length; i++) {
            for (int j = i + 1; j < teams.length; j++) {
                int result = Integer.parseInt(teams[i], 2) | Integer.parseInt(teams[j], 2);
                String resultString = Integer.toBinaryString(result);
                int count = 0;
                //System.out.println(resultString);
                for (int k = 0; k < resultString.length(); k++) {
                    if (resultString.charAt(k) == '1') {
                        count++;
                    }
                }
                if (count >= maxCount) {
                    System.out.println(i +"  " + j );
                    maxCount = count;
                    countMatrix[i] = count;
                }
            }
        }
        for (int i = 0; i < countMatrix.length; i++) {
            if (countMatrix[i] == maxCount) {
                counter++;
            }
        }
        System.out.println(maxCount);
        System.out.println(counter);
    }
}
