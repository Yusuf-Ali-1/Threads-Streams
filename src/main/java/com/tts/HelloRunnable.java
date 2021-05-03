package com.tts;

public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello from a thread! Thread's id: "
                + Thread.currentThread().getId());
    }

}
