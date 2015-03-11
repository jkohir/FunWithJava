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

//https://www.youtube.com/watch?v=aMnn0Jq0J-E

public class QuickSortByJonBentley {
    public static void main(String [] args){
//        int x[]={5,6,8,9,4,7,1,2,3};
        int x[]={1,2,3,4,5,6,7,8,9};
        printArray(x);
        quicksort(x, 0, x.length-1);
//        simpleQuicksort(x, 0, x.length-1);
        printArray(x);
    }
    
    private static void quicksort(int[] x, int l, int u){
        int i,j;
        int t;
        if(l>=u)return;
        t=x[l];
        i=l;
        j=u+1;
        for(;;){
            do i++; while(i <= u && x[i]<t);
            do j--; while(x[j]>t);
            if(i>j) break;
            swap(x,i,j);
            System.out.println("Swap: "+i+" "+j);
            printArray(x);
        }
        swap(x,l, j);
        System.out.println("Swap: "+l+" "+j);
        printArray(x);
        quicksort(x,l, j-1);
        quicksort(x,j+1, u);
    }
    
    private static void swap(int a[], int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    private static void printArray(int x[]){
        System.out.println("\n===============================");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]+"\t");   
        }
        System.out.println("\n===============================");
    }
    
    /*
    Pseudocode: Lomuto's Partitioning
    
    m=l
    for(i=l+1; i<=u; i++)
        if x[i]<x[t]
            swap(++m, i)
    */
    
    private static void simpleQuicksort(int[] x, int l, int u){
        int i=0, m=0;
        if(l>=u) return;
        m=l;
        for(i=l+1;i<=u;i++){
            if(x[i]<x[l])
                swap(x,++m,i);    
        }
        swap(x, l, m);
        simpleQuicksort(x, l, m-1);
        simpleQuicksort(x, m+1, u);
    }
}
