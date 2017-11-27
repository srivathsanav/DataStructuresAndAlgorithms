import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/8/17.
 */
public class LisaWorkbook {

    private int specialProblems = 0;

    private static int findSpecialNumbers(int[] numberOfProblemsInChapter, int maxProblemsPerPage) {
        int specialProblems = 0;
        int pageId = 1;
        List<Integer> specialPageIds = new ArrayList<>();
        for (int i = 0; i < numberOfProblemsInChapter.length; i++) {
            int problemIdStart = 1;
            int problemIdEnd = 0;
            int problemsInChapter = numberOfProblemsInChapter[i];
            if (problemsInChapter <= maxProblemsPerPage) {
                problemIdEnd = problemIdStart + problemsInChapter - 1;
                specialProblems = getSpecialProblems(specialProblems, pageId, specialPageIds, problemIdStart, problemIdEnd);
            } else {
                int count = 0;
                while (problemsInChapter > maxProblemsPerPage) {
                    problemsInChapter = problemsInChapter - maxProblemsPerPage;
                    problemIdStart = maxProblemsPerPage * count + 1;
                    count++;
                    problemIdEnd = maxProblemsPerPage * count;
                    specialProblems = getSpecialProblems(specialProblems, pageId, specialPageIds, problemIdStart, problemIdEnd);
                    pageId++;
                }
                problemIdStart = maxProblemsPerPage * count + 1;

                specialProblems = getSpecialProblems(specialProblems, pageId, specialPageIds, problemIdStart, problemIdStart + problemsInChapter - 1);
            }
            pageId++;
        }
        //System.out.println(specialPageIds);
        return specialProblems;
    }

    private static int getSpecialProblems(int specialProblems, int pageId, List<Integer> specialPageIds, int problemIdStart, int problemIdEnd) {
        boolean specialProblem = findPageRangeMatchWithProblems(problemIdStart, problemIdEnd, pageId);
        if (specialProblem) {
            specialProblems++;
            specialPageIds.add(pageId);
        }
        return specialProblems;
    }

    private static boolean findPageRangeMatchWithProblems (int problemIdStart, int problemIdEnd, int pageNo) {
        if (pageNo >= problemIdStart && pageNo <= problemIdEnd) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[T];

        for(int a0 = 0; a0 < T; a0++){
            a[a0] = in.nextInt();

        }
        System.out.println(findSpecialNumbers(a, k));
    }
}
