/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.codechef.test.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

import fun.codechef.MARCHA4;
import fun.codechef.competitors.MARCHA4_clmathuriya;

/**
 *
 * @author Juned
 */
public class Test {
    public static void main (String[] args) throws java.lang.Exception
    {
//        TestCaseGenerator.generateRandomTestCaseForROTSTRNG();
//        testROTSTRNG();
    	TestCaseGenerator.generateRandomTestCaseForMARCHA4();
    	testMARCHA4();
    }
    
    private static void testROTSTRNG() throws FileNotFoundException, IOException{
        //test it 10,000 times
//        boolean failed = false;
//        for(int i =0; i<10000; i++){
//            System.out.println("Executing test case: "+i);
//            TestCaseGenerator.generateRandomTestCaseForROTSTRNG();
//            int[] output1 = ROTSTRNG.execute();
//            int[] output2 = ROTSTRNG_Balakrishnan_Varadarajan.execute();
//            for (int j = 0; j < output1.length; j++) {
//                if(output1[j]!=output2[j]){
//                    failed = true;
//                    break;
//                }    
//            }
//            if(failed){
//                System.out.println("Failed! Check input file, here are the outputs (Correct:Wrong):");
//                for (int j = 0; j < output1.length; j++) {
//                    System.out.println(output2[j]+":"+output1[j]);
//                }
//                break;
//            }
//        }
//        
    }
    
    private static void testMARCHA4() throws Exception{
    	long yourTime = MARCHA4.execute();
    	long hisTime = MARCHA4_clmathuriya.execute();
    	System.out.println("Your Time: "+yourTime);
    	System.out.println("His Time: "+hisTime);
    }
}
