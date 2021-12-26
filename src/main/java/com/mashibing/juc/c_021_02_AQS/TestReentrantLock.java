package com.mashibing.juc.c_021_02_AQS;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {

    private static volatile int i = 0;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        ReentrantLock lock1 = new ReentrantLock(true);


        lock.lock();

        lock1.lock();
        //synchronized (TestReentrantLock.class) {
        lock.lock();
        lock.lock();
        lock.lock();
            i++;
        //}
        lock1.unlock();
        lock.unlock();


        lock.unlock();
        lock.unlock();
        lock.unlock();

        //synchronized 程序员的丽春院 JUC
    }
}
