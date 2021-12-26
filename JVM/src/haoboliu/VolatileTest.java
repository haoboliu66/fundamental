package haoboliu;

public class VolatileTest {

    static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.out.println("Start");
            while (!flag) {

            }
            System.out.println("End");

        }).start();
        // 不涉及线程可见性
        Thread.sleep(1000);
        flag = true;
        System.out.println("Main End");
    }
}
