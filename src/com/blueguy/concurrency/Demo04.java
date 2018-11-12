package com.blueguy.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo04 {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        FutureTask[] tasks = new FutureTask[3];
        for (int i = 0; i < 3; i++) {
            tasks[i] = startTask(i);
        }
        for (int i = 0; i < 3; i++) {
            FutureTask<Integer> task = tasks[i];
            Integer result = null;
            try {
                result = task.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("计算结果为：" + result);
        }
        System.out.println("所用时间：" + (System.currentTimeMillis() - time1));
    }

    public static FutureTask<Integer> startTask(int i) {
        Callable<Integer> call = () -> {
            System.out.println("线程:" + Thread.currentThread().getName());
            Thread.sleep(500);
            return i;
        };
        FutureTask<Integer> task = new FutureTask<>(call);
        Thread thread = new Thread(task);
        thread.start();
        return task;
    }
}


//        FutureTask<Integer> task1 = startTask(1);
//        FutureTask<Integer> task2 = startTask(2);
//        FutureTask<Integer> task3 = startTask(3);
//        try {
//            System.out.println("开始取结果:");
//            Integer result1 = task1.get();
//            System.out.println("计算结果为：" + result1);
//            Integer result2 = task2.get();
//            System.out.println("计算结果为：" + result2);
//            Integer result3 = task3.get();
//            System.out.println("计算结果为：" + result3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
