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
public class LongestCommonSubsequence {
    public static void main(String[] args){
        String s1="HIEROGLYPHOLOGY";
        String s2="MICHAELANGELO";
        computeCosts("is","hi");
    }
    
    private static void computeCosts(String s1, String s2){
        String longer, shorter;
        if(s1.length()>=s2.length()){
            longer=s1;
            shorter=s2;
        }else{
            longer=s2;
            shorter=s1;
        }
            
        int x=longer.length(); int y=shorter.length();
        int insert=5,delete=5,replace=5;
        char [] longerArray=longer.toCharArray();
        char [] shorterArray=shorter.toCharArray();
        int [][] c=new int[x+1][y+1];
        int i,j;
        
        for(j=y-1;j>=0;j--){
            c[x][j]=1;
        }
        for(i=x-1;i>=0;i--){
            c[i][y]=1;
        }
        //base case c[i][j] is already 0
        
        for(i=x-1; i>=0; i--){
            for(j=y-1; j>=0; j--){
                delete=1+c[i+1][j];
                insert=1+c[i][j+1];
                if(longerArray[i]==shorterArray[j])
                    replace=0+c[i+1][j+1];
                else
                    replace=Integer.MAX_VALUE;
                c[i][j]=min(delete,insert,replace);
            }
        }
        printMatrix(c);
    }
    
    private static int min(int a, int b, int c){
        return Math.min(Math.min(a, b), c);
    }
    
    private static void printMatrix(int[][] a){
        for (int j = 0; j < a[0].length; j++) {
            for (int i = 0; i < a.length; i++) {
                System.out.print("\t"+a[i][j]);
            }
            System.out.println("");
        }
    }
}
