package fun.multithreading;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juned
 */
import java.util.concurrent.Semaphore; 
 
class Q { 
  int n; 
 
  // Start with consumer semaphore unavailable. 
  static Semaphore semCon = new Semaphore(0); 
  static Semaphore semProd = new Semaphore(1); 
 
  void get() { 
    try { 
        boolean permitAvailable=semCon.availablePermits()>0?true:false;
        System.out.println("acquire Con: "+permitAvailable);
      semCon.acquire(); 
    } catch(InterruptedException e) { 
      System.out.println("InterruptedException caught"); 
    } 
 
     System.out.println("Got: " + n); 
     semProd.release(); 
  } 
 
  void put(int n) { 
    try { 
        boolean permitAvailable=semProd.availablePermits()>0?true:false;
        System.out.println("acquire Prod: "+permitAvailable);
      semProd.acquire(); 
    } catch(InterruptedException e) { 
      System.out.println("InterruptedException caught"); 
    } 
 
    this.n = n; 
    System.out.println("Put: " + n); 
    semCon.release(); 
  } 
} 
 
class Producer implements Runnable { 
  Q q; 
 
  Producer(Q q) { 
    this.q = q; 
    new Thread(this, "Producer").start(); 
  } 
 
  public void run() { 
    for(int i=0; i < 20; i++) q.put(i); 
  } 
} 
 
class Consumer implements Runnable { 
  Q q; 
 
  Consumer(Q q) { 
    this.q = q; 
    new Thread(this, "Consumer").start(); 
  } 
 
  public void run() { 
    for(int i=0; i < 20; i++)  q.get(); 
  } 
} 
 
class SemDemo { 
  public static void main(String args[]) { 
    Q q = new Q(); 
    new Consumer(q); 
    new Producer(q); 
  } 
}
