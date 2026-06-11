package core;


class BankAccount {

    int balance = 1000;

    public synchronized void withdraw(int amount) {

        if (balance >= amount) {

            System.out.println(
                Thread.currentThread().getName()
                + " is withdrawing " + amount
            );

            balance = balance - amount;

            System.out.println(
                "Remaining Balance: " + balance
            +" in "+ Thread.currentThread().getName());

        } else {

            System.out.println(
                Thread.currentThread().getName()
                + " insufficient balance"
            );
        }
    }

    public synchronized void deposit(int amount){
        int bal = balance;
        System.out.println("Before Deposit Current Balance : "+balance+" "+Thread.currentThread().getName());
        bal+=amount;
        System.out.println("Updated Balance After Deposit of "+amount+" with "+(bal-amount)+" is "+bal+" "+Thread.currentThread().getName()+" balance : "+balance);
        balance = bal;
    }
}


public class ThreadMoneyWithdrawal {

public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        Runnable task1 = () -> {
            account.withdraw(800);
        };

        Runnable task2 = () -> {
            account.withdraw(500);
        };
        Runnable task3 = () -> {
            account.deposit(3000);
        };

        Runnable task4 = () -> {
            account.deposit(600);
        };

        Thread t1 = new Thread(task1, "ATM-1");
        Thread t2 = new Thread(task2, "ATM-2");
        Thread t3 = new Thread(task3, "ATM-3");
        Thread t4 = new Thread(task4, "ATM-4");

        t1.start();
        t2.start();

        // t1.join();
        // t2.join();

        t3.start();
        t4.start();


        t3.join();
        t4.join();
        System.out.println(account.balance);


        
    }
}
