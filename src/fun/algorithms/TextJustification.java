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
public class TextJustification {
    public static void main(String []args){
        String[] input= {"Geeks", "for", "Geeks", "presents", "word", "wrap", "problem"};
        justify(input, 15);
    }
    
    private static void justify(String[] words,int pagewidth){
	int [] DP=new int[words.length];
        int n =words.length,temp;
	DP[n-1]=0;
        for (int i =n-2 ; i >= 0; i--) {
            int min=Integer.MAX_VALUE;
            for (int j =i+1 ; j<n; j++){
                temp=badness(words,i,j,pagewidth)+DP[j];
                if(min<temp)
                    min=temp;
            }
            DP[i]=min;
            System.out.println(i+": "+DP[i]);
        }
    }


    private static int badness(String[] words, int i, int j, int pagewidth){
	int totalwidth=words.length, badness=0;
	for(;i<=j;i++){
		if(i!=j)
			totalwidth+=words[i].length()+1;
		else
			totalwidth+=words[i].length();
	}
	if(pagewidth<totalwidth)badness=Integer.MAX_VALUE;
	else badness=(pagewidth-totalwidth)*(pagewidth-totalwidth);
	return badness;
    }
}
