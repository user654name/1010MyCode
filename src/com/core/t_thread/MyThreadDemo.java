package com.core.t_thread;

public class MyThreadDemo {

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        thread1.start();
        thread1.setPriority(3);

        int priority = thread1.getPriority();
        System.out.println("priority = " + priority);
        thread2.run();


    }

}

class MyThread1 extends Thread{
    @Override
    public void run() {

        System.out.println("线程1 跑起来");
    }
}
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("线程2 跑起来");
    }
}
