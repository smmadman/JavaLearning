/*
 * ThreadTest3.java
 * Copyright 2020 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */
package JUC;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lansen
 *
 */
public class ThreadTest {
    private  ReentrantLock lock = new ReentrantLock();

    private  Condition c1 = lock.newCondition();
    private  Condition c2 = lock.newCondition();
    private  Condition c3 = lock.newCondition();

    private static Thread thread1, thread2, thread3;

    private static int i = 0;
    private static int state = 0;


    public static void main(String[] args) throws InterruptedException {
        ThreadTest threadTest3 = new ThreadTest();
        threadTest3.runThread();
    }
    public void runThread() throws InterruptedException {
        thread1 = new Thread(new MyThread1());
        thread2 = new Thread(new MyThread2());
        thread3 = new Thread(new MyThread3());
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public class MyThread1 implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 34; j++) {
                try {
                    lock.lock();
                    if (state != 0) {
                        c1.await();
                    }
                    System.out.println("ThreadT1" + " ------> " + i);
                    i++;
                    state = 1;
                    c2.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public class MyThread2 implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 33; j++) {
                try {
                    lock.lock();
                    if (state != 1) {
                        c2.await();
                    }
                    System.out.println("ThreadT2" + " ------> " + i);
                    i++;
                    state = 2;
                    c3.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    public class MyThread3 implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 33; j++) {
                try {
                    lock.lock();
                    if (state != 2) {
                        c3.await();
                    }
                    System.out.println("ThreadT3" + " ------> " + i);
                    i++;
                    state = 0;
                    c1.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }
    }

}

