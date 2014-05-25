/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithms;

import java.util.Arrays;

/**
 *
 * @author Juned
 */
public class MergeSort {
    public static void main(String[] args){
        int[] input={10,9,8,7,6,5,4,3,2,1};
        int[] sorted=mergeSort(input);
        for(int i:sorted){
            System.out.print(i+" "); 
        }
    }
    
    private static int[] mergeSort(int[] a){
        if(a.length<2)
            return a;
        int[] a1=Arrays.copyOfRange(a, 0, a.length/2);
        int[] a2=Arrays.copyOfRange(a, a1.length, a.length);
        return merge(mergeSort(a1),mergeSort(a2));
    }
    
    private static int[] merge(int[] a1, int[] a2){
        int[] sorted=new int[a1.length+a2.length];
        int i=0,j=0,k=0;
        while(i<a1.length && j<a2.length){
            if(a1[i]<=a2[j]){
                sorted[k++]=a1[i++];
            }else{
                sorted[k++]=a2[j++];
            }
        }
        while(i<a1.length){
            sorted[k++]=a1[i++];
        }
        while(j<a2.length){
            sorted[k++]=a2[j++];
        }
        return sorted;
    }
}
