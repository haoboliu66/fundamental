package com.hbliu;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestBreak {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        t1.run();
    }



    int a = 0;
    boolean flag = false;

    @Test
    public void test() throws InterruptedException {
        new Thread(() -> {
            writer();
        }).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            try {
                reader();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(a);
    }

    public void writer() {
        a = 2;
        flag = true;
    }

    public void reader() throws InterruptedException {
        System.out.println("reader....");
        System.out.println(a);
        System.out.println(flag);
        if (flag) {
            a += 1;
        }
        System.out.println(a);
    }

}
