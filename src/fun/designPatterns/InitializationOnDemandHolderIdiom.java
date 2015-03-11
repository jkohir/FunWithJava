/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fun.designPatterns;

/**
 *
 * @author Juned
 */
public class InitializationOnDemandHolderIdiom {
    private InitializationOnDemandHolderIdiom(){}
    
    private static class Singleton{
        
        private static final InitializationOnDemandHolderIdiom INSTANCE=new InitializationOnDemandHolderIdiom();
    }
    
    public static InitializationOnDemandHolderIdiom getInstance(){
        return Singleton.INSTANCE;
    }
}
