package com.shoy.multhithreading.fairlock;

/**
 * A test running class
 * User: shoy
 * Date: 5/10/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class FairLockRun extends Thread {
    FairLockTest test;
    public FairLockRun (FairLockTest test1) {
        test = test1;
    }
    
    @Override
    public void run() {
        System.out.println("Thread 1 is starting the function");
        test.doSynchronized(1);
    }
}
