package core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThread {

    public static void main(String[] argv) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            int taskId = i; // it must be final or fixed
            executor.submit(() -> {

                System.out.println(
                        "Thread Name : " + Thread.currentThread().getName() + " , Executing for :" + taskId + " task");
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("Error in Catch of " + taskId + " is :" + e.getMessage());
                } finally{
                    System.out.println("Task executed :"+taskId);
                }
            });
        }

        executor.shutdown();
    }

}
