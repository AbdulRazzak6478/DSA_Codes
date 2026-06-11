package core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncFuture {
    public static void main(String[] args) throws Exception {
        
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable t1 = ()->{
            System.out.println("Thread one is Running :"+Thread.currentThread().getName());
           try {
             Thread.sleep(6000);
             System.out.println("Thread one is completed  :"+Thread.currentThread().getName());
           } catch (Exception e) {
            // TODO: handle exception
           }
        };
        Runnable t2 = ()->{
            System.out.println("Thread two is Running :"+Thread.currentThread().getName());
           try {
             Thread.sleep(3000);
             System.out.println("Thread two is completed:"+Thread.currentThread().getName());
           } catch (Exception e) {
            // TODO: handle exception
           }
        };

        executor.submit(t1);
        executor.submit(t2);

        Callable<String> callTask = ()->{
            String str = "My Name i Madara Uchiha";

            Thread.sleep(3000);
            return str;
        };
        Callable<String> callTask2 = ()->{
            String str = "The Ghost Of Uchiha";

            Thread.sleep(6000);
            return str;
        };

        Future<String> f1 = executor.submit(callTask);
        Future<String> f2 = executor.submit(callTask2);


        System.out.println("before tag");
        String villainTag = f2.get();
        System.out.println("after tag");
        System.out.println("Future 2 : "+villainTag);
        System.out.println("before name");
        String villainName = f1.get();
        System.out.println("after name");
        System.out.println("Future 1 : "+villainName);

        System.out.println("before direct");
        String str = executor.submit(callTask).get();
        System.out.println("after direct");
        System.out.println("all in one : "+str);



        // Callable and future





        executor.shutdown();

    }
}
