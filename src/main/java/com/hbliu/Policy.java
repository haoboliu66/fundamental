package com.hbliu;

import java.util.concurrent.*;

public class Policy {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService es = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                        if (!e.isShutdown()) {
                            r.run();
                            System.out.println("caller in handler: " + Thread.currentThread().getName());
                        }
                    }
                });

        System.out.println("Started");
        for (int i = 0; i < 2000; i++) {
            es.submit(() -> {
                try {
                    // 每个线程里等的都是2s, 所以不一定谁先结束
                    Thread.sleep(2000);
//                    System.out.println("Executing thread name:" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Done");
//        es.shutdown();
//        try {
//            es.awaitTermination(1, TimeUnit.MINUTES);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


    }

}
