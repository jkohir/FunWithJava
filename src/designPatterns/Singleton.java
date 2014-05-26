/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designPatterns;

import java.lang.reflect.Constructor;

/**
 *
 * @author Juned
 */
public class Singleton {

//    private static final Singleton INSTANCE = new Singleton();
    private static Singleton INSTANCE;
    
    static{
        System.out.println("static block initialized");
    }
    
    {
        System.out.println("Initialization block");
    }

    public Singleton() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Inside JavaSingleton(): JavaSingleton " + "instance already created.");
        }
        System.out.println("Inside JavaSingleton(): Singleton instance is being created.");
    }

    public static final Singleton getInstance() {
        if(INSTANCE == null){
            INSTANCE=new Singleton();
        }
        return INSTANCE;
    }
}

class TestSingleton {

    public static void main(String[] args){
        System.out.println("Inside main(): Getting the singleton instance using getInstance()...");
//        Singleton s = Singleton.getInstance();
        Singleton s1=new Singleton();
//        System.out.println("Inside main(): Trying to use reflection to get another instance...");
//        Class<Singleton> clazz = Singleton.class;
//        Constructor<Singleton> cons = clazz.getDeclaredConstructor();
//        cons.setAccessible(true);
//        Singleton s2 = cons.newInstance();
    }
}
