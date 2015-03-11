/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.main;

import java.util.Arrays;

/**
 *
 * @author Juned
 */
public class CoinChange {
    public static void main(String[] args){
        int counts = count1(new int[]{5,2,3,1,4},5,5);
        System.out.println("counts: "+counts);
    }

    private static int count(int[] s, int m, int n) {
        // table[i] will be storing the number of solutions for
        // value i. We need n+1 rows as the table is consturcted
        // in bottom up manner using the base case (n = 0)
        int[] table = new int[n+1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++)
            for(int j=s[i]; j<=n; j++)
                table[j] += table[j-s[i]];
        for(int i=0; i<=n; i++)
            System.out.print(table[i]);
        return table[n];
    }
    
    private static int count1(int S[], int m, int n) {
        int i, j, x, y;
        String line = "1 2 3";
        String[] arr = line.split(" ");
        // We need n+1 rows as the table is consturcted in bottom up manner using 
        // the base case 0 value case (n = 0)
        int[][] table = new int[n + 1][m];

        // Fill the enteries for 0 value case (n = 0)
        for (i = 0; i < m; i++) {
            table[0][i] = 1;
        }
        
        // Fill rest of the table enteries in bottom up manner  
        for (i = 1; i < n + 1; i++) {
            for (j = 0; j < m; j++) {
                // Count of solutions including S[j]
                x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

                // Count of solutions excluding S[j]
                y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;
            }
        }
        
        for (i = n; i >=0; i--) {
            for (j = 0; j < m; j++) {
                System.out.print(table[i][j]);
            }
            System.out.println("");
        }
        
        return table[n][m - 1];
    }


}
