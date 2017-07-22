package Thread;

/**
 * Created by qianle on 7/18/17.
 */
public class ThreadDemo {

    public static void main(String[] args) {
        SubThread sub = new SubThread();
        sub.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("main..." + i);
        }
    }
}
