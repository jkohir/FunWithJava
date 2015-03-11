/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.algorithms;

/**
 *
 * @author jkohir
 */
public class HeapSort {
    public static void main(String[] args){
        int heapArr[]={5,6,8,9,2,3,1,4,7,0,0};
//        int [] heapArr = heapify(input);
//        int [] sortedArr = heapSort(heapArr);
        int n=9;
        buildHeap(heapArr,n);
//        buildHeapUsingInsert(heapArr,n);
        for(int i=0;i<n;i++)
            System.out.print(heapArr[i]+" ");
        System.out.println("");
//        heapSort(heapArr,n);
//        for(int i=0;i<n;i++)
//            System.out.print(heapArr[i]+" ");
//        System.out.println("");
        System.out.println("inserting 11 and 10");
        insert(heapArr, 11, n);
        n++;
        insert(heapArr, 10, n);
        n++;
        for(int i=0;i<n;i++)
            System.out.print(heapArr[i]+" ");
        System.out.println("");
        heapSort(heapArr,n);
        for(int i=0;i<n;i++)
            System.out.print(heapArr[i]+" ");
        System.out.println("");
    }
    
    private static int[] heapify(int [] input){
        int [] heapArr=new int[input.length];
        for(int i=0; i < input.length; i++){
            insert(heapArr,input[i],i);
        }
        return heapArr;
    }
    
    private static void heapSort(int [] heapArr, int n){
//        int n=heapArr.length;
        for(int i=n-1; i >0; i--){
//            sortedArr[i]=deleteRoot(heapArr);
            swap(heapArr,0,i);
            n--;
            maxHeapUsingLoop(heapArr, 0, n);
        }
    }
    
    private static void insert(int [] heapArr, int data, int n){
        heapArr[n]=data;
        int i=n;
        int parent=i/2;
        while(parent>=0 && heapArr[i]>heapArr[parent]){
            swap(heapArr, i, parent);
            i=parent;
            parent=i/2;
        }
    }
    
    public static void buildHeapUsingInsert(int[] a, int n){
        for(int i=0;i<n; i++){
            insert(a,a[i],i);
        }
    }
    
    private static void buildHeap(int [] heapArr, int n){
//        int n=heapArr.length;
        for(int i=n/2; i>=0; i--){
            maxHeapUsingLoop(heapArr, i, n);
        }
    }
    
    private static void maxHeapUsingRecursion(int []a, int i, int n){
//        int n=a.length;
        int left=i*2+1;
        int right=left+1;
        int largest=i;
        if(left<n && a[left]>a[i]){
            largest=left;
        }
        if(right<n && a[right]>a[largest]){
            largest=right;
        }
        if(i!=largest){
            swap(a,i,largest);
            maxHeapUsingRecursion(a,largest, n);
        }
        
    }
    
    private static void maxHeapUsingLoop(int []a, int i, int n){
//        int n=a.length;
        int left,right,largest=-1;
        
        while(true){
            left=i*2+1;
            right=left+1;
            largest=i;
            if(left<n && a[left]>a[i]){
                largest=left;
            }
            if(right<n && a[right]>a[largest]){
                largest=right;
            }
            if(i!=largest){
                swap(a,i,largest);
                i=largest;
            }else{
                break;
            }
        }
    }
    
    private static void swap(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
//    private static int deleteRoot(int [] heapArr){
//        
//    }
}
