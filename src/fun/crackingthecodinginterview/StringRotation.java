/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.crackingthecodinginterview;

/**
 *
 * @author Juned
 */

/*
Given two strings find the Rotation Distance between them. For a pair of strings which are rotations of each other, 
rotation distance is the MINIMUM distance between the respective elements of both the strings. If the strings are not 
rotations of each other, then return -1.

*/

public class StringRotation {
    public static void main(String [] args){
        String s1="ABACDE";
        String s2="CDEABA";
        System.out.println("Rotation distance for strings is: "+getRotationDistance(s1, s2));
    }
    
    private static int getRotationDistance(String s1, String s2){
        int distance=-1;
        int startIndex=-1;
        if(!((s1.length() == s2.length()) && ((startIndex=(s1+s1).indexOf(s2)) != -1)))
            return -1;
        if(startIndex<=(s1.length()/2))
            distance=startIndex;
        else
            distance=s1.length()-startIndex;
        return distance;
    }
    
}
