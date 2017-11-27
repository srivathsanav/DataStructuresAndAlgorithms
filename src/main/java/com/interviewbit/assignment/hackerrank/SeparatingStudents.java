import java.io.*;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by srivathsan on 10/9/17.
 */
public class SeparatingStudents {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int res;
        int avg_size = 0;
        avg_size = Integer.parseInt(in.nextLine().trim());

        int[] avg = new int[avg_size];
        for(int i = 0; i < avg_size; i++) {
            int avg_item;
            avg_item = Integer.parseInt(in.nextLine().trim());
            avg[i] = avg_item;
        }

        res = minMoves(avg);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    private static int minMoves(int[] students) {

        int start = 0;
        int end = students.length - 1;
        int minMoves = 0;

        while (start < end) {
            if (students[start] == 1) {
                start++;
            } else if (students[end] == 0) {
                end--;
            } else {
                minMoves = minMoves + end - start;
                start++;
                end--;
            }
        }
        return minMoves;
    }
}
