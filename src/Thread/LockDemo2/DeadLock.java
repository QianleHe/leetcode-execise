package Thread.LockDemo2;

public class DeadLock implements Runnable{


    private int i = 1;
    @Override
    public void run() {
        while(true) {
            if (i % 2 == 1) {
                synchronized (LockA.lockA) {
                    System.out.println("if.... LockA");
                    synchronized (LockB.lockB) {
                        System.out.println("if ...... LockB");
                    }
                }
            } else {
                synchronized (LockB.lockB) {
                    System.out.println("else..... LockB");
                    synchronized (LockA.lockA) {
                        System.out.println("else ...... LockA");
                    }
                }
            }
            i++;
        }
    }
}
