package LLD.solid.LSP;

import java.util.ArrayList;
import java.util.List;

interface depositAccount {

    public void deposit(double amount);
}

interface withdrawAccount extends depositAccount {
    public void withdraw(double amount);
}

class SavingAccount2 implements withdrawAccount {

    private double balance;

    public SavingAccount2() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Saving Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Saving Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Saving Account!");
        }
    }
}

class CurrentAccount2 implements withdrawAccount {

    private double balance;

    public CurrentAccount2() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount2 implements depositAccount {

    private double balance;

    public FixedTermAccount2() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }

}

class BankClient3 {
    List<withdrawAccount> accounts;
    List<depositAccount> accounts2;

    public BankClient3(List<withdrawAccount> accounts,List<depositAccount> accounts2) {
        this.accounts = accounts;
        this.accounts2 = accounts2;
    }

    public void processTransactions() {
        for (withdrawAccount acc : accounts) {
            try {
                acc.deposit(1000);
                acc.withdraw(500);
            } catch (Exception e) {
                System.out.println("Exception in withdraw Accounts: " + e.getMessage());
            }
        }
        for (depositAccount acc : accounts2) {
            try {
                acc.deposit(36000);
                // acc.withdraw(5060);
            } catch (Exception e) {
                System.out.println("Exception in withdraw Accounts: " + e.getMessage());
            }
        }
    }

}

public class LSPFollowed {

    public static void main(String[] args) {
        List<withdrawAccount> accounts = new ArrayList<>();
        accounts.add(new SavingAccount2());
        accounts.add(new CurrentAccount2());

        List<depositAccount> accounts2 = new ArrayList<>();
        accounts2.add(new FixedTermAccount2());

        BankClient3 client = new BankClient3(accounts,accounts2);

        client.processTransactions();
    }
}
