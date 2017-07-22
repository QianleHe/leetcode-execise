package Thread;

import java.util.concurrent.*;

public class ThreadDemo2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 101; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        es.shutdown();
    }
}
