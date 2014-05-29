/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Comparator;

/**
 *
 * @author jkohir
 */
public class TreeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if(o1.age>o2.age)
            return 1;
        else if(o1.age<o2.age)
            return -1;
        else
            return 0;
    }
    
    
}
