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
public class HeapSortNow {
    public static void main(String [] args){
        int a[]={5,8,3,6,9,4,7,2,1,10};
        buildHeap(a);
        //printArray(a);
        System.out.println(isBottomUpMaxHeap(a, 0));
        System.out.println(isTopDownMaxHeap(a, 0));
        heapSort(a);
        printArray(a);
    }
    
    private static void buildHeap(int [] a){
        int n=a.length;
        for(int i=n/2; i>=0; i--){
            maxHeapify(i, a, n);
        }
    } 
    
    private static void maxHeapify(int i, int [] a, int n){
        int left=(i*2)+1;
        int right=left+1;
        int largest=i;
        if(left<n && a[left]>a[largest])
            largest=left;
        if(right<n && a[right]>a[largest])
            largest=right;
        if(largest!=i){
            swap(a,i,largest);
            maxHeapify(largest,a,n);
        }
    }
    
    private static void swap(int [] a, int x, int y){
        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;
    }
    
    private static void heapSort(int [] a){
        int n=a.length;
        for(int i=n-1; i>=0; i--){
            swap(a,0,i);
            n--;
            maxHeapify(0, a, n);
        }
    }
    
    private static void printArray(int[] a){
        System.out.println("\n==================================\n");
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+"\t");
    }
    
    private static boolean isBottomUpMaxHeap(int[]a, int i){
        if(i>=a.length)
            return true;
        int left=i*2+1;
        int right=left+1;
        //first check whether left and right subtrees are heaps
        boolean isLeftHeap=isBottomUpMaxHeap(a,left);
        boolean isRightHeap=isBottomUpMaxHeap(a,right);
        if(left>=a.length || right>=a.length)
            return true;
        //now check whether the tree starting with this node is a heap
        if(isLeftHeap && isRightHeap)
        {
            if(a[i]>a[left] && a[i]>a[right])
                return true;
        }
        return false;
    }
    
    private static boolean isTopDownMaxHeap(int[]a, int i){
        if(i>=a.length)
            return true;
        int left=i*2+1;
        int right=left+1;
        boolean amIHeap=false;
        if(left>=a.length)
            return true;
        else if(right>=a.length)//case where a node only has a left child
            //first check whether the tree starting with this node is a heap
            amIHeap=(a[i]>a[left]);
        else
            //first check whether the tree starting with this node is a heap
            amIHeap=(a[i]>a[left] && a[i]>a[right]);
        //if current tree is not heap, don't bother checking subtrees
        if(!amIHeap)
            return false;
        //now check whether left and right subtrees are heaps
        boolean isLeftHeap=isTopDownMaxHeap(a,left);
        boolean isRightHeap=isTopDownMaxHeap(a,right);
        
        return amIHeap && isLeftHeap && isRightHeap;
    }
}
