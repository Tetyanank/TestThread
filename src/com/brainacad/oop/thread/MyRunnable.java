package com.brainacad.oop.thread;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable " + Thread.currentThread().getName());

    }
}
