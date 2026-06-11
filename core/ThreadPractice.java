package core;

class MyThread1 extends Thread {

    public void run() {

        System.out.println("MyThread1 is running ");
    }
}

class Counter {

    int counter;

    public synchronized void increment()
    {
        counter++;
    }
}

public class ThreadPractice {
    public static void main(String[] args) throws Exception {

        // Thread t1 = new MyThread1();
        // System.out.println("Started Thread Execution");
        // t1.start();
        // t1.run();
        // try {
        //     MyThread1.sleep(2000);
        // } catch (Exception e) {
        //     System.out.println("Error:" + e.getMessage());
        // }
        // t1.run();
        // System.out.println("Testing Thread");


        Counter c = new Counter();

        Runnable task1 = ()->{
            for(int i=0;i<1000;i++){
                c.increment();
            }
        };
        Runnable task2 = ()->{
            for(int i=0;i<1000;i++){
                c.increment();
            }
        };

        Thread t1 = new Thread(task1);

        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Counter Value:"+c.counter);


    }
}
