/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Juned
 */
public class Germin8Test {
        public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
		*/
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String[] nums = line.split(" ");
            int n = Integer.parseInt(nums[0]);
            int k = Integer.parseInt(nums[1]);
            int m = Integer.parseInt(nums[2]);
            int[] s = new int[k];
            for(int j =0; j<k; j++){
            	s[j]=j+1;
            }
            int count = getCount(s, k, m, n);
            System.out.println(count);
        }
    }
    
    private static int getCount(int[] s, int k, int m, int n){
    	
    	int i, j, x, y;
    	int[][] table = new int[n+1][k];
    	
    	for(i = 0; i<k; i++){
    		table[0][i]=1;
    	}
    	
    	for(i=1; i<n+1; i++){
    		for(j=0; j<k; j++){
    			//count of solutions including s[j]
    			x = (i-s[j]>=0)? table[i-s[j]][j] : 0;
    			//count of solutions excluding s[j]
    			y = (j>0)? table[i][j-1] : 0;
    			//total count
    			table[i][j]=x+y;
    		}
    	}
    	
    	for(i=n; i>=0; i--){
    		for(j=0; j<m; j++){
    			System.out.print(table[i][j]);
    		}
    		System.out.println();
    	}
    	
    	return table[n][k-1];
    }
}
