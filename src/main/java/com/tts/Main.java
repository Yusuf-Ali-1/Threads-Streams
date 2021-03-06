package com.tts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // This main method is known as our entry point
    // but in fact, it's also known as our main thread
    // The main thread has the ability to create additional threads
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Hello world, I'm in a main thread!");

        // We create a new Thread instance
        // We pass a runnable object into that instance
        // Thread has a method called start() with it invokes
        // To begin the execution of our runnable
        new Thread (new HelloRunnable()).start();

        // Second method to run thread
        Thread th = new Thread(new HelloRunnable());
        th.start();

        // Third method to run thread using lambda
        // Keep in mind that Runnable is a functional interface
        // We can use lambda expressions to implement its method
        Runnable task = () ->
            System.out.println("Hello from a lambda! Thread's id: "
                    // This is how we would get the Thread's id
            + Thread.currentThread().getId());

        // currentThread().getId() will access the id of the thread below
        new Thread(task).start();

        // Custom thread class
        (new HelloThread()).start();


        // Sleep Message
        String[] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0; i < importantInfo.length; i++) {
            // I want to pause the executing thread
            //Pause for 4 seconds = 4000 milliseconds
            Thread.sleep(4000);
            //Print a message after the pause
            System.out.println(importantInfo[i]);

        }

        // List is an interface
        // this is a form of polymorphism
        // List<Integer> myList = new ArrayList<>();


        // Interruption of threads
        // below is an anonymous inner class
        // you can only make lambdas from runnable interfaces
        Runnable messageTask = new Runnable() {
            @Override
            public void run() {

                //enhanced for loop of importantInfo
                for (String s : importantInfo) {
                    // Pause for 4 seconds
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // We've been interrupted: no more messages.
                        return;
                    }
                    // Print a message
                    System.out.println(s);
                }

            }
        };


        // method to call messageTask
        (new Thread(messageTask)).start();


    }
}
