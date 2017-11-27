import java.util.concurrent.CountDownLatch;

/**
 * Created by avsrivathsan on 6/20/2017.
 */
public class Foo {
    private CountDownLatch firstLatch = new CountDownLatch(1);

    private CountDownLatch secondLatch = new CountDownLatch(1);

    public Foo() {  }
    public void first() {
        System.out.println("first");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        firstLatch.countDown();
    }
    public void second() {
        try {
            firstLatch.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        secondLatch.countDown();
        System.out.println("second");
    }

    public void third() {
        try {
            secondLatch.await();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("third");
    }

    public static void main(String[] args) {
        Foo foo = new Foo();

        for (int i = 0 ; i < 10; i++) {
            Thread thread1 = new Thread(new Thread1(foo));
            Thread thread2 = new Thread(new Thread2(foo));
            Thread thread3 = new Thread(new Thread3(foo));

            thread1.start();
            thread2.start();
            thread3.start();
        }

    }

}


class Thread1 implements Runnable {
    Foo foo;
    public Thread1(Foo foo) {
        this.foo = foo;
    }
    public void run() {
        foo.first();
    }
}

class Thread2 implements Runnable {
    Foo foo;

    public Thread2(Foo foo) {
        this.foo = foo;
    }
    public void run() {
        foo.second();
    }
}

class Thread3 implements Runnable {
    Foo foo;

    public Thread3(Foo foo) {
        this.foo = foo;
    }
    public void run() {
        foo.third();
    }
}