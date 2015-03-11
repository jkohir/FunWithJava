/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fun.algorithms;

/**
 *
 * @author jkohir
 */
public class MaximalSubarray {
    
    public static void main(String [] args){
        flipTheBits();
//        maximalSubArray();
    }
    
    private static void maximalSubArray(){
//        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
//        int A[] = {1, 0, 1, 0, 0, 1, 0, 1};
        int arr[] = {-1, 1, -1, 1, 1, -1, 1, -1};
        int N = arr.length;

        int x = 0;
        int y = 0;
        int left=0,right=0;
        for (int n = 0; n < N; n++) {
            if(y==0 && y + arr[n]>0)
                left=n;
            y = max(y + arr[n], 0);
            if(y>x)
                right=n;
            x = max(x, y);
        }

        System.out.println("Maximum sum = "+ x +" range= ["+left+" , "+right+"]");
    }
    
    private static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    
    private static void flipTheBits(){
        int A[] = {1, 0, 1, 0, 0, 1, 0, 1};
        int sum = 0;

        // count the 1s in the original array and
        // do the 0 -> 1 and 1 -> -1 conversion
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            A[i] = A[i] == 0 ? 1 : -1;        
        }
        //{-1, 1, -1, 1, 1, -1, 1, -1};
        // find the maximum subarray
        class Node { int value; int left; int right;};
        Node y = new Node();
        Node x = new Node();
        x.value=0;x.left=0;x.right=0;
        y.value=0;y.left=0;
        
        for (int n = 0; n < A.length; n++) {
            // update y
            if (y.value + A[n] >= 0) {
                y.value += A[n];
            } else {
                y.left = n+1;
                y.value = 0;
            }
            // update x
            if (x.value < y.value) {
                x.left = y.left;
                x.right = n;
                x.value = y.value;
            }
        }

        // convert the result back
        System.out.println("result = " + (sum + x.value) + " in range [" + x.left + ", " + x.right + "]");
    }
    
}
