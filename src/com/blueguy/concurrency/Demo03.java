package com.blueguy.concurrency;

public class Demo03 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        new Thread(thread).start();
        new Thread(thread).start();
    }

}

class MyThread implements Runnable{
    @Override
    public synchronized void run() {
        for( int i=0;i<10;i++)
            System.out.println(Thread. currentThread().getName()+" counter:"+i);
    }
}

