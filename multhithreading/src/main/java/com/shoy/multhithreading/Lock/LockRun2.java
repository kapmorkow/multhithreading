package com.shoy.multhithreading.Lock;

/**A test running class
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class LockRun2 extends Thread{
    LockTest test; 
    public LockRun2 (LockTest test1) {
        test = test1;
    }
    
    @Override
    public void run() {
        test.newMessage("Thread2 changed the message!");
        System.out.println("Current message: "+ test.getMessage());
    }
}
    
