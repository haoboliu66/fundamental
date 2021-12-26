package com.book.basic_api;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestStop {

    private static class User {
        int id;
        String name;

        public User() {
            id = 0;
            name = "0";
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    private static User user = new User();
    private static Object object = new Object();

    public static void main(String[] args) {

        Thread changeThread = new Thread(() -> {
            synchronized (object) {
                user.id = 1;
                System.out.println("change thread.......");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                user.name = "1";
            }

        });

        Thread readThread = new Thread(() -> {
            synchronized (object) {
                System.out.println(user);
            }
        });
        changeThread.start();
        readThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeThread.stop();


    }

}
