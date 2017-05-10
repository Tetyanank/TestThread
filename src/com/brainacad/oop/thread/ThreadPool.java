package com.brainacad.oop.thread;
// позволяет использовать поол пототоки , необходим для создания поол потоков
import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

public class ThreadPool {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor(); // поол с одного потока
    private static ExecutorService executorService1 = Executors.newFixedThreadPool(4); // поол точным указанием кол-ва потоков

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int val = i;
            executorService1.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("start " + val );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end " + val);
                }
            }) ;
        }
        executorService1.shutdown();     // необходим для остановки потока

    }
}
