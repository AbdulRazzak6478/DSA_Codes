package LLD.solid.LSP;

import java.util.ArrayList;
import java.util.List;

interface Account {

    public void deposit(double amount);

    public void withdraw(double amount);
}

class SavingAccount implements Account {

    private double balance;

    public SavingAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " Deposits in Saving Account, Total balance : " + this.balance);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Not Sufficient Amount To Withdraw ");
            return;
        }

        this.balance -= amount;
        System.out.println("Amount : " + amount + " withdraw from Saving Account");
    }
}

class CurrentAccount implements Account {

    private double balance;

    public CurrentAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " Deposits in Current Account, Total balance : " + this.balance);
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            System.out.println("Not Sufficient Amount To Withdraw ");
            return;
        }

        this.balance -= amount;
        System.out.println("Amount : " + amount + " withdraw from Current Account");
    }
}

class FixedAccount implements Account {

    private double balance;

    public FixedAccount() {
        this.balance = 0;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(amount + " Deposits in Fixed Account, Total balance : " + this.balance);
    }

    public void withdraw(double amount) {
        throw new UnsupportedOperationException("withdraw not allowed in fixed term Account");
    }
}

class BankClient {
    public List<Account> accounts = new ArrayList<>();

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void processTransactions() {
        for (Account a : this.accounts) {
            try {
                a.deposit(4000);

                a.withdraw(3000);
            } catch (Exception e) {
                System.out.println("Exception Error Message " + e);
            }
        }
    }
    // public void processTransactions() {
    // for (Account acc : accounts) {
    // acc.deposit(1000);

    // // Checking account type explicitly
    // if (acc instanceof FixedAccount) {
    // System.out.println("Skipping withdrawal for Fixed Term Account.");
    // } else {
    // try {
    // // System.out.println("Testing");
    // acc.withdraw(500);
    // } catch (UnsupportedOperationException e) {
    // System.out.println("Exception: " + e.getMessage());
    // }
    // }
    // }
    // }

}

class LSPViolated {

    public static void main(String[] args) {
        System.out.println("In Violated type");
        List<Account> accounts = new ArrayList<>();

        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedAccount());

        BankClient client = new BankClient(accounts);

        client.processTransactions();

    }
}
