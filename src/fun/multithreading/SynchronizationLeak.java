/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juned
 */

//This program demonstrates the fact that if we try to acquire lock on a non final reference to an object, and if the non final reference changes and 
//refers to another object then the code under the synchronized block won't remain synchronized.

public class SynchronizationLeak {
    static int i=0;
    static Object lock=new Object();
    public static void main(String [] args){
        Runnable task=new Runnable() {

            @Override
            public void run() {
                while(i<50){
                    try {
                    updateAndPrinti();
                    
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SynchronizationLeak.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread t = new Thread(task, "Thread 1");
        Thread t1 = new Thread(task, "Thread 2");
        Thread t2 = new Thread(task, "Thread 3");
        Thread t3 = new Thread(task, "Thread 4");
        Thread t4 = new Thread(task, "Thread 5");
        t.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    
    private static void updateAndPrinti() throws InterruptedException{
        synchronized(lock){ 
            i++;
            System.out.println("value of i: "+i+" updated by: "+Thread.currentThread());
            if(i==5){
                lock=new Object();
                Thread.sleep(100);
            }
        }
    }
    
    private static void setObject(Object o){
        lock=o;
    }
    
    
}
