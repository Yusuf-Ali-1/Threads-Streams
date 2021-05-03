package com.tts;

public class HelloThread extends Thread{

    @Override
    public void run(){
        System.out.println("Hello from a custom thread class! Here is the thread's id: "
        + Thread.currentThread().getId());
    }
}
