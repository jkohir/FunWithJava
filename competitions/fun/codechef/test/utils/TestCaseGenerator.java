/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef.test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 *
 * @author Juned
 */
public class TestCaseGenerator {
    public static void generateRandomTestCaseForROTSTRNG() throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\Rotstrng-random-input.txt"));
        Random randomGenerator = new Random();
        int n;
        pw.println(10);
        for (int testCase = 1; testCase <= 10; ++testCase){
//          if(testCase>5)  
//            n = randomGenerator.nextInt(500000) + 1;
//          else
            n = randomGenerator.nextInt(500000) + 1;
          //generate string
          for(int i=0; i<n; i++){
              int c = randomGenerator.nextInt(52);
              if(c>=26)
                  c=(c-26)+97;
              else
                  c+=65;
//              c+=97;
              pw.print((char)c);
          }
          pw.print('\n');
          //print m and p
          int m = randomGenerator.nextInt(n)+1;
          int p = randomGenerator.nextInt(n)+1;
          pw.println(m+" "+p);
        }
        pw.close();
    }
    
	public static void generateRandomTestCaseForMARCHA4()
			throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("D:\\Google Drive\\Books\\My code musings\\Codechef\\MARCHA4\\MARCHA4-random-input.txt"));
		Random randomGenerator = new Random();
		int n, k;
		pw.println(30000);
		for (int testCase = 1; testCase <= 30000; ++testCase) {
			n = randomGenerator.nextInt((int) Math.pow(10, 9)) + 1;
//			k = randomGenerator.nextInt(9) + 1;
			k=1;
			pw.println(n + " " + k);
		}
		pw.close();

	}
}
