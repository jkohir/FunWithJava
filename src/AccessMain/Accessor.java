/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AccessMain;

import main.Classes;

/**
 *
 * @author jkohir
 */
public class Accessor {
    {
        Classes classes=new Classes();
        //Child.Inner inner=new Child.Inner(); // not allowed
        Classes.publicInner publicinner=classes.new publicInner(); // This is the correct way to initialize a non private Inner class
//        Classes.defaultInner defaultinner=classes.new defaultInner();//cannot access outside package as it is default
//        Classes.privateInner privateinner=classes.new privateInner();//has private access in main.Classes, can't be accessed
    }
}
