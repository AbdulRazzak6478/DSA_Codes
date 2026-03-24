package core;

class User {
    String name;

    User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        //
        return "Hello World";
    }

}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

class User2 {

}

public class JavaLang {

    public static void main(String[] args) {
        User u = new User("Rahul");
        User2 u2 = new User2();

        System.out.println(u.toString());
        System.out.println(u.equals(u2));
        System.out.println(System.currentTimeMillis() + "time in milliseconds");
        Runtime r = Runtime.getRuntime();

        System.out.println(r.totalMemory());
        System.out.println(r.freeMemory());

        MyThread th = new MyThread();
        // sleep();
        // th.sleep(3000);
        th.start();
        // th.sleep(5000);

        try{
            int a = 10 /0 ;
            // throw new Exception("Test");

            // Throwable
        }catch(Exception e)
        {
            System.out.println("Error cought in exception :"+e.getMessage());
        }

        

    }
}
