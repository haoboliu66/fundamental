/**
 * volatile 引用类型（包括数组）只能保证引用本身的可见性，不能保证内部字段的可见性
 */
package com.mashibing.juc.c_012_Volatile;

import java.util.concurrent.TimeUnit;

public class T02_VolatileReference1 {

    boolean running = true;

    volatile static T02_VolatileReference1 T = new T02_VolatileReference1();

    void m() {
        System.out.println("m start");
        System.out.println("this == " + this);
        while(running) {

        }
        System.out.println("m end!");
    }

    public static void main(String[] args) {
        new Thread(T::m, "t1").start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                T.m();
//            }
//        }).start();

        //lambda new Thread(new Runnable( run() {m()}

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }
}
