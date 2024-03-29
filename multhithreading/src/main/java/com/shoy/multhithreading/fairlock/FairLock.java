package com.shoy.multhithreading.fairlock;

import java.util.ArrayList;
import java.util.List;


/**A Fair Lock implementation
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class FairLock {
    /**Define whether the resource is locked*/
    private boolean isLocked = false;
    
    /**Which thread has actually locked the resource*/
    private Thread lockingThread = null;    
    /**The queue of waiting threads - wanting to grab the resource*/
    private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

    /**Locks the resource*/
    public void lock() throws InterruptedException{
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized(this){
            //queue the threads 
            waitingThreads.add(queueObject);
        }

        while(isLockedForThisThread){
            synchronized(this){
                isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
                if(!isLockedForThisThread){
                    //take the resource
                    isLocked = true;
                    //not waiting anymore
                    waitingThreads.remove(queueObject);
                    //current
                    lockingThread = Thread.currentThread();
                    return;
                }
            }
            try{
                queueObject.doWait();
            }catch(InterruptedException e){
                synchronized(this) { waitingThreads.remove(queueObject); }
                throw e;
            }
        }
    }

    /**Unlocks the resource*/
    public synchronized void unlock(){
        //the thread did not lock this!
        if(this.lockingThread != Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        //free the resource
        isLocked = false;
        //nobody's locking now
        lockingThread = null;
        //call the thread waiting
        if(waitingThreads.size() > 0){
            waitingThreads.get(0).doNotify();
        }
    }
}
