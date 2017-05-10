package com.brainacad.oop.thread;

public class ValiataleSample {
    static volatile int val = 0 ;       // запрещает кеширование переменной, чтоб поток использовал глобальную

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int localVal = val;     // из-за того что берет локальную, не работает проверка
                while(localVal < 5) {       // берет только локальную, и не видит изменения со второго потока
                    if (localVal != val) {  // т.к. там происходят изменения глобальной переменной
                        System.out.println("Local val = " + val);
                        localVal = val;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int localVal = val;
                while(val < 5) {
                    System.out.println("Increment val to " + (localVal + 1));
                    val = ++localVal;
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
