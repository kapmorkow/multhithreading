package com.shoy.multhithreading.threadpool;

/**A Task implementation
 * Created with IntelliJ IDEA.
 * User: shoy
 * Date: 5/10/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Task implements Runnable
{
    int k;
    public Task (int j)
    {
        k = j;
    }
   
    @Override
    public void run ()
    {
        System.out.print(k);
    }

}
