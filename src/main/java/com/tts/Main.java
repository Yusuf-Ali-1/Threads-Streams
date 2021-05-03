package com.tts;

public class Main {
    //this main method is known as our entry point
    // but in fact, it's also known as our main thread
    // The main thread has the ability to create additional threads
    public static void main(String[] args) {

        System.out.println("Hello world, I'm in a main thread");

        // We create a new Thread instance
        // we pass a runnable object into that instance
        // thread has a method called start() with it invokes
        // to begin the execution of our runnable
        new Thread (new HelloRunnable()).start();

        //Second method to run thread
        Thread th = new Thread(new HelloRunnable());
        th.start();

        // Third method to run thread using lambda
        // Keep in mind that Runnable is a functional interface
        // we can use lambda expressions to implement its method
        Runnable task = () ->
            System.out.println("Hello from a lambda! Here is the thread's id: "
            + Thread.currentThread().getId());
        new Thread(task).start();

    }
}
