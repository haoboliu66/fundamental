package com.hbliu.c01_threadbasic;

import java.util.concurrent.TimeUnit;

public class Test_Interrupt {


    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (; ; ) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread interrupted");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                } else {
                    System.out.println("Nope");
                }
            }
        });

        t.start();

        TimeUnit.SECONDS.sleep(2);

        t.interrupt();
    }

}
