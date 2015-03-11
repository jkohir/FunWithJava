/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juned
 */
public class StringPermuteWithRepititions {
    
    public static void main(String[] args){
//        permute("","abbd");
        findSubsets("", "abc");
    }

    private static void permute(String start, String remaining) {
        if(remaining.equals("")){
            System.out.println(start);
            return;
        }
        List<Character> chars = new ArrayList<Character>();
        for(int i = 0; i<remaining.length(); i++){
            char c = remaining.charAt(i);
            if(!chars.contains(c)){
                chars.add(c);
                String newStart=start+c;
                String newRemaining=remaining.substring(0, i)+remaining.substring(i+1);
                permute(newStart,newRemaining);
            }
        }
    }
    
    private static void findSubsets(String start, String remaining){
        if(remaining.equals("")){
            System.out.println(start);
            return;
        }
        //find subset with the first char included
        findSubsets(start+remaining.charAt(0), remaining.substring(1));
        //find subset without the first char included
        findSubsets(start, remaining.substring(1));
    }
}
