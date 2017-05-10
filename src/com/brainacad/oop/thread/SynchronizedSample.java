package com.brainacad.oop.thread;

import java.util.Objects;

public class SynchronizedSample {
    public static Integer val = 0;
    static Object lock = new Object();      // объявлена переменная для синхронизации

    public static void main(String[] args) {
     /* new NonSynchronizedThread("NonSync1").start();
      new NonSynchronizedThread("NonSync2").start();*/

        new SynchronizedThread("Sync1").start();
        new SynchronizedThread("Sync2").start();
    }
// обеспечивает доступ к блоку только одному потоку, следующий поток должен джать пока не закончит работу предыдуший
    //private static synchronized void changeVal()   синтаксис для синхронизации методов
    private static  void changeVal() {
        while (val < 5) {
            val++;
            System.out.println(String.format("%s: %d", Thread.currentThread().getName(), val));
        }
        val = 0;
    }

    static class SynchronizedThread extends Thread {

        public SynchronizedThread(String name) {
            super(name);
        }

        @Override
        public void run() {     // SynchronizedThread.class- объект класса
            // synchronized (SynchronizedThread.class)
            synchronized (lock) {   // в один момент времени доступен только одному потоку
                changeVal();
            }
        }
    }

    static class NonSynchronizedThread extends Thread {
        public NonSynchronizedThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            changeVal();
        }
    }
}
