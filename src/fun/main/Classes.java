/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jkohir
 */
public class Classes {

    public static void main(String args[]) throws InterruptedException {
  
        NotUsed o = null; //this class is not used, should not be initialized
        //Child t = new Child(); //initializing sub class, should trigger super class initialization
        //System.out.println((Object)o == (Object)t);
        
        //accessing non final static field of Parent through child, should only initialize Parent's static block
        System.out.println(Child.familyName);
//        Classes classes=new Classes();
//        Classes.privateInner privateinner=classes.new privateInner();//can only be accessed in this class, no other class
    }
    
    public class publicInner{
        
    }
    
    class defaultInner{
        
    }
    
    private class privateInner{
        
    }
    
    private static class privateStaticInner{
        
    }
}

/**
 * Super class to demonstrate that Super class is loaded and initialized before Subclass.
 */
class Parent {
    
    //compile time constant, accessing this will not trigger class initialization
//    protected static final String familyName = "Lawson";
    protected static final Parent familyName = new Parent();
//    protected static String familyName = "Lawson";
    
    Parent(){
        System.out.println("Inside Parent's constructor");
        ArrayList<String> a= new ArrayList<String>(); 
        ArrayList b= new ArrayList<String>();
        b.add(1);
        b.add("x");
        a=b;
        a.add("x");
        for (int i = 0; i < b.size(); i++){
            System.out.println(b.get(i));  
        }
    }
    
    static 
    { 
        System.out.println("static block of Super class is initialized"); 
    }
    {
        System.out.println("initialization block in super class is initialized");
//        Child child=new Child();
        //Child.Inner inner=new Child.Inner(); // not allowed
//        Child.Inner inner=child.new Inner(); // This is the correct way to initialize a non private Inner class
    }
    
    public void method(){
        System.out.println("supera");
    }
    
    class MyInner extends Parent{
    @Override
    public void method(){
        System.out.println("subba");
    }
    }
}

/**
 * Java class which is not used in this program, consequently not loaded by JVM
 */
class NotUsed {
    static { System.out.println("NotUsed Class is initialized "); }
}

/**
 * Sub class of Parent, demonstrate when exactly sub class loading and initialization occurs.
 */
class Child extends Parent {
    private  final int outerprivatefinal;
    private int outerPrivate;
    static int i;
    static 
    { 
        System.out.println("static block of Sub class is initialized in Java "); 
    }
    {
        outerprivatefinal=0;
        System.out.println("initialization block in sub class is initialized");
        Inner inner=new Inner();
        inner.innerprivate=2; //accessing private variable of inner class through its object is allowed !
//        innerprivate=2; //can't access without object of inner class
        Classes classes=new Classes();
        Classes.defaultInner defaultinner=classes.new defaultInner();//can access default inner here, within package
//        Classes.privateInner privateinner=classes.new privateInner();//has private access in main.Classes, can't be accessed
    }
    
    interface sample{
        void foo();
    }//works !
    
    Child(){
        System.out.println("Constructor of child called"); 
    }
     class Inner{
        //private static final int j; //Won't work unless you initialize right here, not in constructor
        private final int innerprivatefinal; //Won't work if you don't initialize in constructor/initialization block but any other method.
        private int innerprivate;
        private static final int innerprivatestaticfinal=2;//Works, coz static can only be used in the case of constant variables.
        //Also private static final methods or any static method are not allowed, only constant variables are allowed
//        private static innerStaticPrivate; //won't work coz static variables are not allowed in inner classes
        //interface sample{} //Illegal static declaration as interface is inherently static
        {
            System.out.println("Instance block of inner class called"); //Instance block in Inner class is allowed
        }
        //static{} //Not allowed
        
        Inner(){
            innerprivatefinal=0;
        }
        private void method(){
            Child.i=0;
//            outerprivatefinal=2;  //can't assign value here.
//            innerprivatefinal=0; // can't initialize value of final variable in thie method.
            outerPrivate=2; //can access outer private without outer class' object.
            final int finalVar=2;
            int nonfinalVar=2;
//            interface sample{}//not allowed coz, you can't declare static members in a local method and an interface
            //is inherently static
            class Local{
                {
                    System.out.println("final Var: "+finalVar); //access to a final local variable is allowed
//                    System.out.println("non final Var: "+nonfinalVar); //access to a non final local variable is not allowed
                    Child.sample sample= new Child.sample() {
//                        sample(){} //constructor declaration not allowed in Anonymous class
                        @Override
                        public void foo() {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }
                    };
                }
            }
        }
    }    
}

abstract class A implements Serializable{
    public static final int i=1;
    static int j=4;
    public static void method(){
        
    }
    interface x{}
    static String str;
    transient int x;
    
    private void writeObject(ObjectOutputStream o)
    throws IOException {  
    
    o.writeInt(x);
    o.writeChars(str);
  }
  
  private void readObject(ObjectInputStream o)
    throws IOException, ClassNotFoundException {  
    
    o.readInt();
    o.read();
  }
}
