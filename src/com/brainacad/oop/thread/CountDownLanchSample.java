package com.brainacad.oop.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLanchSample {
    static CountDownLatch latch = new CountDownLatch(4);        // значение счетчика

    public static void main(String[] args) {
        for (int i = 0; i <4 ; i++) {
            // запускаем 4 потока
           new Thread(new Runnable() {
               @Override
               public void run() {
                   System.out.println("Thread  " + Thread.currentThread().getId());
                   try {
                       TimeUnit.SECONDS.sleep(3);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   latch.countDown();       // уменьшает значение счетчика
               }
           }).start();


        }
        System.out.println("Waiting ...  ");
        try {
            latch.await();  // пока счетчик не станет равным нулю (ждем пока все потоки не отработают)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished   ");
    }
}
