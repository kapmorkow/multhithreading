package com.shoy.multhithreading.Lock;

/**A test running class
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class LockRun extends Thread{
    LockTest test; 
    public LockRun (LockTest test1) {
        test = test1;
    }
    
    @Override
    public void run() {
        test.newMessage("Thread1 has set new message!");
        System.out.println("Current message: "+ test.getMessage());
    }    
}
