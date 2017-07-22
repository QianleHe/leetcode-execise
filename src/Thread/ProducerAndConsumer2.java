package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer2 {
    public static void main(String[] args) {
        Resource r = new Resource();

        Producer p = new Producer(r);
        Consumer c = new Consumer(r);

        Thread t1 = new Thread(p);
        Thread t3 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t4 = new Thread(c);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Producer2 implements Runnable {
    private Resource r;

    Producer2(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("duck");
        }
    }
}

class Consumer2 implements Runnable {

    private Resource r;

    Consumer2(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(true) {
            r.get("duck");
        }
    }
}

class Resource2 {
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    private String name;
    private int count = 1;
    private boolean flag = false;
    public void set(String name) {
        lock.lock();
        try{
            while (flag) {
                try {
                    c1.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            count++;
            this.name = name + count;
            System.out.println(Thread.currentThread().getName() + "...." + "producer" + " is" + this.name);
            flag = true;
            c2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void get(String name) {
        lock.lock();
        try {
            while (!flag) {
                try {
                    c2.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "........" + "Consumer is" + this.name);
            flag = false;
            c1.signal();
        } finally {
            lock.unlock();
        }


    }
}