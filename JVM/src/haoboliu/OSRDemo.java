package haoboliu;

public class OSRDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start");
        startBusinessThread();
        startProblemThread();

        Thread.sleep(500);

        System.gc();

        System.out.println("main end");
    }

    public static void startProblemThread() {
        new Thread(new MyRun()).start();
    }

    static long counter;

    public static class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("Problem start");
            for (int i = 0; i < 100000000; i++) {
                for (int j = 0; j < 1000; j++) {
                    counter += i % 33;
                    counter += i % 333;
                }
//                method();
            }
            System.out.println("Problem end");
        }
    }

    public static void method() {

    }

    public static void startBusinessThread() {
        new Thread(() -> {
            System.out.println("业务线程-1 start");
            for (; ; ) {
                System.out.println("执行业务1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("业务线程-2 start");
            for (; ; ) {
                System.out.println("执行业务2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
