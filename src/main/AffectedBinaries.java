/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedHashSet;

/**
 *
 * @author jkohir
 */
public class AffectedBinaries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String inFileName="D:\\Juned's Work\\Input.txt";
            String outFileName="D:\\Juned's Work\\Input-copy.txt";
            BufferedReader br=new BufferedReader(new FileReader(inFileName));
            LinkedHashSet<String> set = new LinkedHashSet<String>();
            String str;
            while((str=br.readLine())!=null){
                set.add(str);
                System.out.println("Line 1: "+str);
            }
            System.out.println(set);
            BufferedWriter out = new BufferedWriter(new FileWriter(outFileName));
            String[] strArray=set.toArray(new String[set.size()]);
            for(int i=0;i<strArray.length;i++){
                out.write(strArray[i]);
                if(i!=strArray.length-1)
                    out.write('\n');
            }
            out.close();
            br=new BufferedReader(new FileReader(outFileName));
            while((str=br.readLine())!=null){
                System.out.println("Line 1: "+str);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
