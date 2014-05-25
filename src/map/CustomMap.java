/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.HashMap;

/**
 *
 * @author jkohir
 */
public class CustomMap {
    public static void main(String [] args){
        HashMap<Person,Integer> map = new HashMap();
        Person p=new Person("a", 50);
        Person p1=new Person("b", 50);
        Person p2=new Person("c", 50);
        Person p3=new Person("d", 50);
        Person p4=new Person("d", 50);
        map.put(p, 1);
        map.put(p1, 2);
        map.put(p2, 3);
        map.put(p3, 4);
        map.put(p4, 5);
        p3.age=55;
        p3.name="changed";
        System.out.println(map);
        System.out.println("hashcode p3: "+p3.hashCode()+" p4: "+p4.hashCode());
        System.out.println(map.get(p4));
        
    }
}
