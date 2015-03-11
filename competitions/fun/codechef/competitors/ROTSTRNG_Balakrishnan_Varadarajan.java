/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef.competitors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Juned
 */
public class ROTSTRNG_Balakrishnan_Varadarajan {
    
    public static void main(String[] args) throws FileNotFoundException{
        String A;
        int overlap[] = new int[500020];
        int T;
        Scanner scanner = new Scanner(new FileInputStream(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\Rotstrng-input.txt")));
        T = scanner.nextInt();
        for(int t=1;t<=T;t++)
        {
            A = scanner.next();
            int n=A.length();
            overlap[0]=-1;
            int L=0;
            for(int i=0;i<n;i++)
            {
                L=i+1;
                overlap[i+1]=overlap[i]+1;
                while(overlap[i+1]>0 && A.charAt(i)!=A.charAt(overlap[i+1]-1))
                    overlap[i+1]=overlap[overlap[i+1]-1]+1;
            }
            int period;
            if(L%(L-overlap[L])==0)
                period=(L-overlap[L]);
            else
                period=L;       
            //printf("%d\n",period);
            int M,P;
            M = scanner.nextInt();
            P = scanner.nextInt();
            int offset=0;
            int answer=-1;
            for(int j=1;j<=3*n+1;j++)
            {
                if((j&1)>0)
                    offset+=M;
                else
                    offset+=P;
                offset%=n;
                //printf("%d\n",offset);
                if((offset)%period==0 || offset==0)
                {
                    answer=j;
                    break;
                }

            }
            System.out.println(answer);

        }
    }     
}

