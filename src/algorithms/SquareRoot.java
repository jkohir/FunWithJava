/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package algorithms;

/**
 *
 * @author jkohir
 */
public class SquareRoot {
    public static void main(String[] args){
        int n=5;
        System.out.println("square root of "+n+" is: "+squareRootUsingApproximation(n));
        
        System.out.println("square root of "+n+" is: "+squareRootUsingBisection(n));
    }
    
    private static double squareRootUsingApproximation(double num){
        double low=0, high=num, avg=0;
        double precision=0.01;
        while(high-low>precision){
            avg=(high+low)/(double)2;
            if(avg*avg>=num)
                high=avg;
            else
                low=avg;
            System.out.println("high: "+high+" low: "+low+" avg: "+avg);
        }
        return avg;
    }
    
    private static double squareRootUsingBisection(double num){
        double low=1, high=num, avg=0;
        double precision=0.0001;
        while(Math.abs(high-low)>precision){
            avg=(high+low)/2;
            low=num/avg;
            high=avg;
            
            System.out.println("high: "+high+" low: "+low+" avg: "+avg);
        }
        return avg;
    }
}
