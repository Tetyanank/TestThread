package com.brainacad.oop.thread;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        MyRunnable rnb2 = new MyRunnable();
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread();
           // myThread.setDaemon(true);
            myThread.start();        // start() - запускает ввыполнение потока

        }
        String str = "New String";
        for(int i=0; i<3; i++){
        System.out.println("Hello world new ");
            for (int j=5; j>=0; j--) {
            System.out.println(j); 
            }
        }
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
