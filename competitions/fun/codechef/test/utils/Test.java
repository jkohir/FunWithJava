/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef.test.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import fun.codechef.test.classes.MARCHA4;
import fun.codechef.test.classes.MARCHA4_clmathuriya;
import fun.codechef.test.classes.ROTSTRNG;
import fun.codechef.test.classes.ROTSTRNG_Balakrishnan_Varadarajan;

/**
 *
 * @author Juned
 */
public class Test {
    public static void main (String[] args) throws java.lang.Exception
    {
//        TestCaseGenerator.generateRandomTestCaseForROTSTRNG();
//        testROTSTRNG();
    	long divisor = (long) Math.pow(10, 19);
    	BigInteger x = new BigInteger("10020665353275723941229320043534774560");
    	x = x.divide(BigInteger.valueOf(divisor));
    	System.out.println(x);
//    	testMARCHA4();
    }
    
    private static void testROTSTRNG() throws FileNotFoundException, IOException{
        //test it 10,000 times
        boolean failed = false;
        for(int i =0; i<10000; i++){
            System.out.println("Executing test case: "+i);
            TestCaseGenerator.generateRandomTestCaseForROTSTRNG();
            int[] output1 = ROTSTRNG.execute();
            int[] output2 = ROTSTRNG_Balakrishnan_Varadarajan.execute();
            for (int j = 0; j < output1.length; j++) {
                if(output1[j]!=output2[j]){
                    failed = true;
                    break;
                }    
            }
            if(failed){
                System.out.println("Failed! Check input file, here are the outputs (Correct:Wrong):");
                for (int j = 0; j < output1.length; j++) {
                    System.out.println(output2[j]+":"+output1[j]);
                }
                break;
            }
        }
        
    }
    
    private static void testMARCHA4() throws Exception{
    	//will test for 100 test cases
    	long yourTime = 0;
    	long hisTime = 0;
    	List<Integer> failedNumbers = new ArrayList<Integer>();
    	for (int i = 0; i < 25; i++) {			
    		TestCaseGenerator.generateRandomTestCaseForMARCHA4();
    		yourTime += MARCHA4.execute();
    		hisTime += MARCHA4_clmathuriya.execute();
    		for (int j = 0; j < MARCHA4.firstKList.size(); j++) {
				if(!MARCHA4.firstKList.get(j).equals(MARCHA4_clmathuriya.firstKList.get(j)) || 
						!MARCHA4.lastKList.get(j).equals(MARCHA4_clmathuriya.lastKList.get(j))){
					failedNumbers.add(MARCHA4.numbers.get(j));
					System.out.println(i+": FAILED! for n: "+MARCHA4.numbers.get(j));
					System.out.println(MARCHA4_clmathuriya.firstKList.get(j)+" "+MARCHA4_clmathuriya.lastKList.get(j)+" "+MARCHA4.firstKList.get(j)+" "+MARCHA4.lastKList.get(j));
//					break;
				}
			}
		}
    	printMinimumFailedNumber(failedNumbers);
    	System.out.println("Your Time: "+yourTime/100);
    	System.out.println("His_ Time: "+hisTime/100);
    }

	private static void printMinimumFailedNumber(List<Integer> failedNumbers) {
		int minIndex=0;
		for (int i = 0; i < failedNumbers.size(); i++) {
			int failedNumber = failedNumbers.get(i);
			if(failedNumber<failedNumbers.get(minIndex)){
				minIndex = i;
			}
		}
		System.out.println("Mininum failed number: "+failedNumbers.get(minIndex));
		System.out.println(MARCHA4_clmathuriya.firstKList.get(minIndex)+" "+MARCHA4_clmathuriya.lastKList.get(minIndex)+" "+MARCHA4.firstKList.get(minIndex)+" "+MARCHA4.lastKList.get(minIndex));
	}
}
