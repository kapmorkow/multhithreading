package com.shoy.multhithreading.Lock;

/**A Lock implementation
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lock {
    /**Is the resource blocked?*/
    private boolean isLocked = false;
    
    /**
     * Lock the resource
     * @throws InterruptedException 
     */
    public synchronized void lock() throws InterruptedException{
        //waiting the resource
        while(isLocked){ wait();}
        //taking it
        isLocked = true;
    }
    
    /**
     * give resourses away
     */
    
    public synchronized void unlock(){
        isLocked = false;
        //tell everybody
        notify();
    }

    /**
     * Try to lock the resource
     * @return success?
     */
    public synchronized boolean trylock(){
        if (!isLocked)
        {
            //take it
            isLocked = true;
            return true;
        }
        //fail
        else return false;
    }
}
