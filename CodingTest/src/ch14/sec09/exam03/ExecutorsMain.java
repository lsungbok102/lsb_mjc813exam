package ch14.sec09.exam03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsMain {
    public static void main(String[] args) {
        Long ms = System.currentTimeMillis();
        ExecutorService es = Executors.newFixedThreadPool(5);

        ISumLoop callback = new ISumLoop() {
            @Override
            public void print(Long num) {
            }
        };

        for (int i = 1; i <= 100000; i++) {
            final int idx = i;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    Long sum = 0L;
                    for (int j = 1; j <= idx; j++) {
                        sum += j;
                    }
//                    System.out.printf("[%s] 1~%d = %d\n",
//                            Thread.currentThread().getName(),
//                            idx, sum);
                    callback.print(sum);
                }
            });
        }

        es.shutdown();
        ms = System.currentTimeMillis() - ms;
        System.out.printf("totalMills = %d\n", ms);
    }
}
