package haoboliu;

public class Test2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (t1) {
                System.out.println("t2 start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1 isAlive:" + t1.isAlive());
            }
        });
        t2.start();

    }


}
