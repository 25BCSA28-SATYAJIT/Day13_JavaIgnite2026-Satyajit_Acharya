/*
Create a Java program to simulate a bank system with a shared account balance.

Task:
Initial account balance = 10,000
Create two threads:
Thread 1 → performs 5 withdrawals (random amounts between 500–2000)
Thread 2 → performs 5 deposits (random amounts between 500–2000)
Requirements:
Both threads should operate on the same account balance
Print updated balance after every transaction
Ensure balance never goes negative
Hint:

Think step-by-step:

Shared resource = balance variable
Use synchronization concept (important idea: avoid race condition)
Each thread modifies same data
Control access carefully
*/
import java.util.Random;
import java.util.Scanner;

class BankAccount {
    int balance = 10000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount + " Balance: " + balance);
        }
        else {
            System.out.println("Withdraw failed ");
        }
    }

    public synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount + "Balance: " + balance);
    }
}

class WThread extends Thread {
    BankAccount account;
    Random r = new Random();

    WThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = 500 + r.nextInt(1501); 
            account.withdraw(amount);

            try {
                Thread.sleep(200);
            } 
            catch (Exception e) {
              System.out.println("Error Handeled");
            }
        }
    }
}

class DThread extends Thread {
    BankAccount account;
    Random r = new Random();

    DThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            int amount = 500 + r.nextInt(1501);
            account.deposit(amount);

            try {
                Thread.sleep(200);
            } 
            catch (Exception e) {
              System.out.println("Error Handeled");
            }
        }
    }
}


public class Banking_Transaction_Simulation {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WThread t1 = new WThread(account);
        DThread t2 = new DThread(account);

        t1.start();
        t2.start();
    }
}
