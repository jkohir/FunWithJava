/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.main;

/**
 *
 * @author Juned
 */
public class Finally {
    public static void main(String[] args){
        System.out.println(confusing());
    }
    
    private static String confusing(){
        try{
            try{
                    try{
                        System.out.println("kya bakwaas hai yeh sab!");
                        int x=5/0;
                        return "kaun kar raha hai yeh sab!";
                    }catch(Exception e){
                        return "caught";
                    }finally{
                        return "one";
                    }
            }finally{
                return "two";
            }
        }finally{
//            
            return "three";
        }
    }
}
