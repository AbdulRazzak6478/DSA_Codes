package core;

import java.util.LinkedList;
import java.util.Queue;

class Table {
    Queue<Integer> queue = new LinkedList<>();
    int capacity = 5;

    public synchronized  void produce(int item) throws Exception
    {
        while(queue.size() == capacity)
        {
            wait();
        }
        queue.add(item);
        System.out.println("added :"+item+ " and table "+queue);
        notify();
    }

    public void consume() throws Exception {

        while(queue.isEmpty()){
            wait();
        }

        int item = queue.poll();
        System.out.println("Consumed : "+item+" and the table is "+queue);
        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        Table tb = new Table();
        Runnable producer = ()->{
            System.out.println("In side the producer");
            try{
                int value=1;
                while(true)
                {
                    tb.produce(value++);
                    Thread.sleep(1000);
                }
            }catch(Exception e)
            {}
        };
        Runnable consumer = ()->{
            System.out.println("in side the consumer");
            try{
                while(true)
                {
                    tb.consume();
                    Thread.sleep(1500);
                }
            }catch(Exception e)
            {}
        };

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);

        p.start();
        c.start();

        p.join();
        c.join();


        // dir /s /B src\main\java\*.java > sources.txt
        // Get-ChildItem -Recurse src/main/java/*.java | Select-Object -ExpandProperty FullName > sources.txt
        // javac -d out (Get-ChildItem -Recurse src/main/java/*.java).FullName
        // java -cp out com.example.user_management.Main
    }
}
