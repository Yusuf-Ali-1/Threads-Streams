package com.tts;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread! here is the thread's id: "
                + Thread.currentThread().getId());
    }

}
