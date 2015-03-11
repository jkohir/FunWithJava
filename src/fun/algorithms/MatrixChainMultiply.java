/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.algorithms;

import java.util.ArrayList;

/**
 *
 * @author Juned
 */

//http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/Dynamic/chainMatrixMult.htm

public class MatrixChainMultiply {
    public static void main(String[] args){
        int[] p={30,35,15,5,10,20,25};
        multiplyChainOrder(p);
    }
    
    private static void multiplyChainOrder(int[] p){
        int n=p.length;
        int [][] m=new int[n][n];
        int [][] s=new int[n][n];
        int c;
        for(int l=2; l<n; l++){
            for(int i=1; i<n-l+1; i++){
                int j=i+l-1;
                m[i][j]=Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    c=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(c<m[i][j]){
                        m[i][j]=c;
                        s[i][j]=k;
                    }
                }
            }
        }
        print2D(m);
        System.out.println("================================");
        print2D(s);
        System.out.println("===================================");
        printOptimalParenthesis(s, 1, n-1);
    }
    
    private static void print2D(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
    private static void printOptimalParenthesis(int[][]s, int i, int j){
        if(i==j)
            System.out.print("A"+i);
        else{
            System.out.print("(");
            printOptimalParenthesis(s, i, s[i][j]);
            printOptimalParenthesis(s, s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
