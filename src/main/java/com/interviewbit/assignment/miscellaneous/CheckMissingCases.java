import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by avsrivathsan on 8/8/2017.
 */
public class CheckMissingCases {

    private static Set<String> readFile(String file) throws IOException{
        //reading file line by line in Java using BufferedReader
        FileInputStream fis = null;
        BufferedReader reader = null;
        Set<String> firstList = new HashSet<>();
        try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));


            String line = reader.readLine();

            while(line != null){
                String lines[] = line.split("<CaseUrn>");
                String secondLines[] = lines[1].split("</CaseUrn>");
                boolean added = firstList.add(secondLines[0]);
                if (!added) {
                    System.out.println("Duplicate " + secondLines[0]);
                }
                line = reader.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return firstList;
    }

    public static void main(String[] args) {
        try {
            Set<String> firstList = readFile("D:/test.out");
            System.out.println("*****");
          //  Set<String> secondList = readFile("D:/test1.out");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
