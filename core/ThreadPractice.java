package core;

class MyThread1 extends Thread {

    public void run() {

        System.out.println("MyThread1 is running ");
    }
}

public class ThreadPractice {
    public static void main(String[] args)  {

        Thread t1 = new MyThread1();
        System.out.println("Started Thread Execution");
        t1.start();
        t1.run();
        try {
            MyThread1.sleep(2000);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        t1.run();
        System.out.println("Testing Thread");
        // // output
        // MyThread1 is running
        // MyThread1 is running
        // MyThread1 is running
        // Testing Thread

    }
}
