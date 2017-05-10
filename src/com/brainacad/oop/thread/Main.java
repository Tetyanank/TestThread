package com.brainacad.oop.thread;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread();
           // myThread.setDaemon(true);
            myThread.start();        // start() - запускает ввыполнение потока

        }
        System.out.println("Hello world new ");
        Thread thread = new Thread(new MyRunnable());
        thread.setName("Test");
        // выставлять приоритет до вызова метода старт
        thread.setPriority(10);
      //  thread.setDaemon(true);
        thread.start();

        // методы у потока, или как управлять потоками

        System.out.println("getId  " + thread.getId());
        System.out.println("getName  " + thread.getName());
        System.out.println("getState  " + thread.getState());   // позволяет узнать состояние потока


        thread.interrupt();     // прерывает выполнение потока (


    }
}
