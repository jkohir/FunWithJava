/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.multithreading;

/**
 *
 * @author Juned
 */
public class Ajeeb extends Thread {

    private int x = 2;

    public static void main(String[] args) throws Exception {
        System.out.println("executing thread: "+Thread.currentThread());
        new Ajeeb().makeItSo();
        System.out.println("executing thread: "+Thread.currentThread());
    }

    public Ajeeb() {
        x = 5;
        start();
    }

    public void makeItSo() throws Exception {
        System.out.println("in join executing thread: "+Thread.currentThread());
        join();
        x = x - 1;
        System.out.println(x);
    }

    public void run() {
        System.out.println("executing thread: "+Thread.currentThread());
        System.out.println("i am now in run");
        x *= 2;
    }

}
