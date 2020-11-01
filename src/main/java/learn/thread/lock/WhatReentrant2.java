package learn.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WhatReentrant2 {
    public static void main(String[] args) {

        final ReentrantLock lock = new ReentrantLock();
        final Condition condition1 = lock.newCondition();
        final Condition condition2 = lock.newCondition();

        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();

                    System.out.println("ll");
                    condition1.await();
                    System.out.println("oo");
                    condition2.await();
                    System.out.println("hh");
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    System.out.println("kk");
                    condition1.signal();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                try {
                    lock.lock();
                    System.out.println("pp");
                    condition2.signal();
                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }
        }).start();

    }
}
