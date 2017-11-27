import java.util.ArrayList;
import java.util.List;

/**
 * Created by avsrivathsan on 7/27/2017.
 */
public class SimpleTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Adam");
        names.add("Adam");
        names.add("Adam");
        names.add("joe");
        names.add("sri");
        names.add("sri");
        names.add("jack");
        names.add("jill");
        names.add("ebay");
        names.add("ebay");
        int result = 0;
        for (int i = 1; i < names.size(); i++) {
            if (!names.get(i).equals(names.get(result))) {
                names.set(++result, names.get(i));
            }
        }
        names.subList(++result, names.size()).clear();
        System.out.println(names);
    }
}
