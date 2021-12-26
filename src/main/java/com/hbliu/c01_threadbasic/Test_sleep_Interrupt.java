package com.hbliu.c01_threadbasic;

import java.util.concurrent.TimeUnit;

public class Test_sleep_Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("exception here");
                System.out.println("in catch: " + Thread.currentThread().isInterrupted());
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
