package Thread;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Resource r = new Resource();

        Producer p = new Producer(r);
        Consumer c = new Consumer(r);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {
    private Resource r;

    Producer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.set("duck");
        }
    }
}

class Consumer implements Runnable {

    private Resource r;

    Consumer(Resource r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(true) {
            r.get("duck");
        }
    }
}

class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;
    public synchronized void set(String name) {
        while (flag) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count++;
        this.name = name + count;
        System.out.println(Thread.currentThread().getName() + "...." + "producer" + " is" + this.name);
        flag = true;
        this.notifyAll();
    }

    public synchronized void get(String name) {
        while (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "........" + "Consumer is" + this.name);
        flag = false;
        this.notifyAll();

    }
}


