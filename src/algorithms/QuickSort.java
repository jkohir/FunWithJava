/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author jkohir
 */
public class QuickSort {
    
    public static void main(String[] args){
        int[] a={9,7,5,1,2,3,4,6,8,11,10};
        System.out.println("Original Array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
//        System.out.println("\nSorted Array: ");
        System.out.println("");
        quickSortUsingPartialTailRecursion(a, 0, a.length-1);
//        quickSortUsingLoop(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        
        int a1[]={9,7,5,1,2,3,4,6,8,11,10};
        System.out.println("kth element: "+quickselect(a1, 5));
    }

    static int partition(int arr[], int left, int right, int pivot) {
        int i = left, j = right;
        int tmp;
//        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        };

        return i;
    }

    static void quickSort(int arr[], int left, int right) {
        int index = partition(arr, left, right, arr[(left+right)/2]);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }
    
    static int myPartition(int a[], int left, int right){
        int i=left,j=right,tmp;
        int pivot= a[(left+right)/2];
        
        while(i<=j){
            while(a[i]<pivot)
                i++;
            while(a[j]>pivot)
                j++;
            if(i<=j){
                tmp=a[i];
                a[i++]=a[j];
                a[j++]=tmp;
            }
        }
        return i;
    }
    
    static void myQuickSort(int[] a, int left, int right){
        int index=partition(a, left, right, a[(left+right)/2]);
        if(left<index-1)
            myQuickSort(a, left, index-1);
        if(index<right)
            myQuickSort(a, index, right);
    } 
    
    static void quickSortUsingPartialTailRecursion(int[] a, int left, int right){
        
        while(left<right){
            int index=partition(a, left, right, a[(left+right)/2]);
            System.out.println("left: "+left+" right: "+right+" index: "+index);
            printArray(a, left, right);
            quickSortUsingPartialTailRecursion(a, left, index-1);
            left=index;
        }
    }
    
    static void quickSortUsingLoop(int[] a, int left, int right){
        int index;
        while(left<right){
            index=partition(a, left, right, a[(left+right)/2]);
            System.out.println("left: "+left+" right: "+right+" index: "+index);
            partition(a, left, index-1, a[(left+right)/2]);
            System.out.println("left: "+left+" right: "+(index-1)+" index: "+index);
            left=index;
        }
    }
    
    static void printArray(int[] a, int left, int right){
        System.out.println("");
        for(int i=left; i<=right; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    
    static int findKthElement(int []a, int k){
        return a[partition(a, 0, a.length-1, k)];
    }
    
    static int quickselect(int [] a, int k) { 
     int left=0, right = a.length - 1;
     int newPivotIdx,pivotIdx=(0+a.length)/2;
     while (right > left) {
         //Choose a pivot element a[pivotIdx] with left <= pivotIdx <= right
         newPivotIdx = partition(a, left, right, pivotIdx);
         if (k < newPivotIdx) {
             right = newPivotIdx - 1;
         } else {
             left = newPivotIdx + 1;
         }
     }
     return a[k];
    }
}
