package Thread.LockDemo2;

public class DemoRun {



    public static void main(String[] args) {

        DeadLock dead = new DeadLock();
        Thread t = new Thread(dead);
        Thread t2 = new Thread(dead);
        t.start();
        t2.start();

    }
}
