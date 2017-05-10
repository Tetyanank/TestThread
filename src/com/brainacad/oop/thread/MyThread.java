package com.brainacad.oop.thread;


public class MyThread  extends Thread{
    @Override
    public void run() {     // переопределяем метод run()
        System.out.println("Thread started " + this.getName());
        try {
            sleep(3000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread finished  " + this.getName());

    }
}
