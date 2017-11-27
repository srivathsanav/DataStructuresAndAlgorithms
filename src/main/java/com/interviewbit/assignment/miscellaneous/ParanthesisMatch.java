import java.util.*;

/**
 * Created by avsrivathsan on 8/1/2017.
 */
public class ParanthesisMatch {

    public static void wellFormedString(String input) {
       String test = "//test//value//java";
        String[] split = test.split("/");
        for (String value : split) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
       wellFormedString("[]");
    }
}
