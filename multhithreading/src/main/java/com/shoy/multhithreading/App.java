package com.shoy.multhithreading;

import com.shoy.multhithreading.fairlock.FairLockTest;
import com.shoy.multhithreading.fairlock.FairLockRun3;
import com.shoy.multhithreading.fairlock.FairLockRun;
import com.shoy.multhithreading.fairlock.FairLockRun2;
import com.shoy.multhithreading.reentrantlock.ReentrantLockRun;
import com.shoy.multhithreading.reentrantlock.ReentrantLockTest;
import com.shoy.multhithreading.Lock.LockRun;
import com.shoy.multhithreading.Lock.LockRun2;
import com.shoy.multhithreading.Lock.LockRun3;
import com.shoy.multhithreading.Lock.LockTest;
import com.shoy.multhithreading.threadpool.Task;
import com.shoy.multhithreading.threadpool.ThreadPool;

/**
 * Main class - testing the implementations
 * User: shoy
 * Date: 5/10/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class App 
{
    public static void main( String[] args )
    {
        //1
        //Test the Lock implementation
        LockTest test = new LockTest();
        new LockRun(test).start();
        new LockRun3(test).start();
        new LockRun2(test).start();
        new LockRun(test).start();
        new LockRun3(test).start();
        //1
        
        //2
        //Test the Reentrant Lock implementation
        ReentrantLockTest test1 = new ReentrantLockTest();
        new ReentrantLockRun(test1).start();
        new ReentrantLockRun(test1).start();
        //2
        
        //3
        //Test the Fair Lock implementation
        FairLockTest test2 = new FairLockTest();
        new FairLockRun (test2).start();
        new FairLockRun2 (test2).start();
        new FairLockRun3(test2).start();
        new FairLockRun (test2).start();
        new FairLockRun2 (test2).start();
        //3
        
        //4
        //Test the Thread Pool implementation
        ThreadPool m = new ThreadPool (2);
        for (int i =0; i<8;i++) {
            m.execute(new Task(i));
        }
        m.shutDown();
        //4
    }
}
