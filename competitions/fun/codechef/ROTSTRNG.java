/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef;

/**
 *
 * @author Juned
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Name of the class has to be "Main" only if the class is public. */
/*
Example
Input:
2
AbcDef
1 2
aaaaaaaaa
5 5

Output:
4
3


Explanation
Case 1 :
Monkey : fAbcDe , Po : DefAbc, Monkey : cDefAb , Po : AbcDef

Case 2 :
Monkey : cabcab , Po : bcabca, Monkey : abcabc


*/

class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    execute();
	}
	
        private static void execute() throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\Rotstrng-input.txt"))));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0; i<t; i++){
    		String s = br.readLine();
    		String input = br.readLine();
    		String[] inputs = input.split(" ");
    		int x=Integer.parseInt(inputs[0]), y=Integer.parseInt(inputs[1]), count=0;
                long sum=0;
    		int n = getPeriod(s);
    		do{
                    if(count%2==0)
                        sum = sum + x;
    		    else
    		        sum = sum + y;
                    count++;
                    sum%=n;
    		}while(sum%n!=0);
    		System.out.println(count);
	    }
        }
        
	private static int getPeriod(String s){
//            String rep = s + s;
//	    int index = rep.indexOf(s,1);
//	    if(index>=s.length() || index == -1){
//	        index = s.length();
//	    }
            
            int period;
            int n = s.length();
            int[] overlap = new int[n];
            overlap[0]=0;
            
            for (int i = 1; i < s.length(); i++) {
                if(s.charAt(i)==s.charAt(overlap[i-1]))
                    overlap[i]=overlap[i-1]+1;
                else
                    overlap[i]=0;
            }
            if(n%(n - overlap[n - 1])==0)
                period = n - overlap[n - 1];
            else
                period = n;
            
	    return period;
	}
}
