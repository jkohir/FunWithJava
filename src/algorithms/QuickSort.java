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
        int[] a={9,7,3,1,2,5,4,6,8,5,2};
        System.out.println("Original Array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("\nSorted Array: ");
        quickSortUsingTailRecursion(a, 0, a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

    static int partition(int arr[], int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];

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
        int index = partition(arr, left, right);
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
        int index=partition(a, left, right);
        if(left<index-1)
            myQuickSort(a, left, index-1);
        if(index<right)
            myQuickSort(a, index, right);
    } 
    
    static void quickSortUsingTailRecursion(int[] a, int left, int right){
        while(left<right){
            int index=partition(a, left, right);
            quickSortUsingTailRecursion(a, left, index-1);
            left=index;
        }
    }
    
    static void quickSortUsingLoop(int[] a, int left, int right){
        int index;
        while(left<right){
            index=partition(a, left, right);
            partition(a, left, index-1);
            partition(a, index, right);
        }
    }
}
