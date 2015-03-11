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
public class RemoveDuplicates {
    public static void main(String [] args){
        int[] a={1,2,2,6,4,4};
        removeDuplicates(a);
        String str="anagram";
        char[] ch=str.toCharArray();
        removeDuplicates(ch);
        System.out.println("without duplicates: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("\t"+a[i]);
            
        }
        
        System.out.println("\nstring: "+new String(ch));
    }
    
    private static void removeDuplicates(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if(a[i]==a[j]){
                    a[j]=0;
                }
            }
        }
    }
    
    public static void removeDuplicates(char[] str) {
        if (str == null) {
            return;
        }
        int len = str.length;
        if (len < 2) {
            return;
        }
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            int j;
            for (j = 0; j < tail; ++j) {
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
        str[tail] = 0;
    }
}
