package com.mashibing.juc.c_000;

import com.mashibing.juc.c_005.T;

import java.util.HashMap;
import java.util.Map;

public class T04_ThreadState {

    static Map<String, Thread> pot = new HashMap<>();

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(this.getState());

            Thread main = pot.get("main");
            System.out.println("main is " + main);
            System.out.println("main state in run: " + main.getState());

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());
        pot.put("main", Thread.currentThread());
        System.out.println("pot == " + pot);

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());
    }
}
