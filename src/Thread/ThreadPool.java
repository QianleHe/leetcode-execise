package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The usage of threadpool
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 44; i++) {
                    System.out.println(Thread.currentThread().getName() + "..." + i);
                }
            }
        });
        es.submit(new Runnable() {
            public void run() {
                for (int i = 0; i < 44; i++) {
                    System.out.println(Thread.currentThread().getName() + "..." + i);
                }
            }
        });

        // 销毁线程池
        es.shutdown();


        
    }
}
