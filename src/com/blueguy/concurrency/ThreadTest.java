package com.blueguy.concurrency;

public class ThreadTest {

    public static void main(String[] args) {
//        Thread thread = Thread.currentThread();
//        System.out.println(thread.getName());

//        new ThreadA().start();
//        new ThreadA().start();
//        new ThreadA().start();
//        new ThreadA().start();

//        new ThreadA().run();
//        new ThreadA().run();
//        new ThreadA().run();
//        new ThreadA().run();

//        new ThreadB().run();
//        new ThreadB().run();
//        new ThreadB().run();
//        new ThreadB().run();

        new Thread(new ThreadB()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadB()).start();
        new Thread(new ThreadB()).start();
    }

}

class ThreadB implements Runnable {

    private static int num = 0;

    public ThreadB() {
        num++;
    }


    @Override
    public void run() {
        System.out.println("当前线程" + Thread.currentThread().getName());
        System.out.println("主动创建的第" + num + "个线程");
    }
}


class ThreadA extends Thread {

    private static int num = 0;

    public ThreadA() {
        num++;
    }

    @Override
    public void run() {
        System.out.println("当前线程" + Thread.currentThread().getName());
        System.out.println("主动创建的第" + num + "个线程");
    }
}