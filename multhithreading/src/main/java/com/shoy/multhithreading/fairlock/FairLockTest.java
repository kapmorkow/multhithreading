package com.shoy.multhithreading.fairlock;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A test running class
* User: shoy
 * Date: 5/10/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class FairLockTest {
    FairLock lock = new FairLock();
    
    public void doSynchronized(int num) {
        try {
            lock.lock();
            System.out.println("Thread "+num+" grabbed the lock");
            ArrayList k = new ArrayList ();
            //critical section, do a lot of work which takes a long time
            for (int i =0; i< 1000;i++)
                k.add(i);
        } catch (InterruptedException ex) {
            Logger.getLogger(FairLockTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            lock.unlock();
            System.out.println("Thread "+num+" left the lock");
        }
    }
}
