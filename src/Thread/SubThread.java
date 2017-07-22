package Thread;

/**
 * Created by qianle on 7/18/17.
 */
public class SubThread extends Thread{

    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);
        }
    }
}
