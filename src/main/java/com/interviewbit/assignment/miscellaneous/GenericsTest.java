import java.util.LinkedList;
import java.util.List;

/**
 * Created by avsrivathsan on 7/11/2017.
 */
public class GenericsTest<T extends GenericsTest.Person> {

    public static void main(String[] args) {


        new GenericsTest<>().doSomeThing();
    }

    private void doSomeThing() {
        Person e = new Employee();

        List test = new LinkedList();
        test.add("One");
        test.add(1);
        test.add(1.71111);
        test.add(new Employee());
        for (Object val : test) {
            System.out.println(val);
        }
    }

    class Person {

    }

    class Employee extends Person {

    }

    class Tourist extends Person {

    }
}
