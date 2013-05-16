package com.shoy.multhithreading.reentrantlock;

/**A test running class
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReentrantLockRun extends Thread{
    ReentrantLockTest test; 
    public ReentrantLockRun (ReentrantLockTest test1) {
        test = test1;
    }
    
    @Override
    public void run() {
        test.outer();
    }    
}
