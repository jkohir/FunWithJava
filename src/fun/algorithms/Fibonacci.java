/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.algorithms;

/**
 *
 * @author Juned
 */
public class Fibonacci {
    static int memoizationMap[];
    public static void main(String [] args){
        int n=70;
        long startTime,timeTaken;
        startTime=System.nanoTime();
//        System.out.println("Fibonacci for position "+n+": "+fibonacciUsingRecursion(n));
//        timeTaken=System.nanoTime()-startTime;
//        System.out.println("Time taken for traditional recursion: "+timeTaken/1000000);
        
        startTime=System.nanoTime();
        System.out.println("Fibonacci for position "+n+": "+fibonacciUsingLoop(n));
        timeTaken=System.nanoTime()-startTime;
        System.out.println("Time taken for using with loop: "+timeTaken/1000000);
        
        startTime=System.nanoTime();
        System.out.println("Fibonacci for position "+n+": "+fibonacciUsingTailRecursion(0,1,n));
        timeTaken=System.nanoTime()-startTime;
        System.out.println("Time taken for using with tail recursion: "+timeTaken/1000000);
        
        memoizationMap=new int[n];
        startTime=System.nanoTime();
        System.out.println("Fibonacci for position "+n+": "+fibonacciUsingMemoization(n-1));
        timeTaken=System.nanoTime()-startTime;
        System.out.println("Time taken for using with memoization: "+timeTaken/1000000);
        
    }
    
    private static int fibonacciUsingLoop(int n){
        int s1=0,s2=1,sum=0;
        for(int i=n;i>0;i--){
            s1=s2;
            s2=sum;
            sum=s1+s2;
        }
        return sum;
    }
    
    private static int fibonacciUsingRecursion(int n){
        if(n==1 || n==2){
            return 1;
        }
        int num1=fibonacciUsingRecursion(n-1);
        int num2=fibonacciUsingRecursion(n-2);
        int sum=num1+num2;
        return sum;
    }
    
    private static int fibonacciUsingTailRecursion(int s1, int s2, int n){
        if(n==1)
            return s2;
        return fibonacciUsingTailRecursion(s2, s1+s2, n-1);
    }
    
    private static int fibonacciUsingMemoization(int n){
        if(memoizationMap[n]!=0)
            return memoizationMap[n];
        else if(n<2)
            memoizationMap[n]=1;
        else
            memoizationMap[n]=fibonacciUsingMemoization(n-1)+fibonacciUsingMemoization(n-2);
        return memoizationMap[n];
    }
}
