/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.algorithms;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author jkohir
 */
public class Heap1 
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    
    public static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    public static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        }
    
    public static void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
    }
    
    public static void printLevelOrder(int []a){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(a.length);
        int left, right, i=0, n, node;
        n=a.length;
        queue.add(i);
        System.out.println("=======================================");
            
            while(!queue.isEmpty()){
                while(!queue.isEmpty()){
                i=queue.remove();
                left=i*2+1;
                right=left++;
                node=a[i];
                System.out.print(node+"\t");
                if(left<n)
                    queue.add(left);
                if(right<n)
                    queue.add(right);
                }
                System.out.println("");
            }
        System.out.println("=======================================");
    }
    
    public static void main(String[] args) {
        int []a1={4,1,3,2,16,9,10,14,8,7};
//        for(int i=0;i<a1.length;i++){
//            System.out.print(a1[i] + " ");
//        }
//        System.out.println("");
//        printLevelOrder(a1);
        sort(a1);
//        printLevelOrder(a1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
    }
}