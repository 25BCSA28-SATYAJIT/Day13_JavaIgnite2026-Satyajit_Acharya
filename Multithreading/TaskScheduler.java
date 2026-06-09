/*
Create a program with 3 threads:

Thread 1 → prints numbers 1–5
Thread 2 → prints even numbers 2–10
Thread 3 → prints odd numbers 1–9
Task:
Ensure all threads run independently
Print thread name with each output
Hint:

Think:

Each thread = separate class OR Runnable
Use run() method logic
Focus on parallel execution behavior
*/
package java_internship_day13;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Thread1 extends Thread {
    public void run() {
        setName("Thread-1");

        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " -> " + i);

            try {
                Thread.sleep(200);
            } 
            catch (Exception e) {
                System.out.println("Error Haamdled !");          
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        setName("Thread-2 ");

        for (int i = 2; i <= 10; i += 2) {
            System.out.println(getName() + " -> " + i);

            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
                System.out.println("Error Handled !");          
            }
        }
    }
}

class Thread3 extends Thread {
    public void run() {
        setName("Thread-3");

        for (int i = 1; i <= 9; i += 2) {
            System.out.println(getName() + " -> " + i);

            try {
                Thread.sleep(200);
            }
            catch (Exception e) {
              System.out.println("Error Haamdled !");            }
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        t2.start();
        t3.start();
    }
}
