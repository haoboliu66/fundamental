package com.hbliu.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<?> future = es.submit(() -> {
            try {
                while (true) {
                    Thread.sleep(1000);
                    System.out.println("go------");
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        future.get();
        System.out.println("never end.....");


        int i = 0;
        while (i++ != 2){
            Thread.sleep(1000);
            System.out.println("main-----");
        }
        if(future.isDone()){
            System.out.println("f done");
            es.shutdown();
        }
    }

}
