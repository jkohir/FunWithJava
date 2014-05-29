/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.HashMap;
import java.util.TreeMap;

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
//        p3.age=55;
//        p3.name="changed";
        System.out.println(map);
        System.out.println("hashcode p3: "+p3.hashCode()+" p4: "+p4.hashCode()+" equals? "+p3.equals(p4));
        System.out.println(map.get(p4));
        
        TreeMap treeMap=new TreeMap(new TreeComparator());
        Person q=new Person("a", 1);
        Person q1=new Person("b", 2);
        Person q2=new Person("c", 3);
        Person q3=new Person("d", 4);
        Person q4=new Person("d", 4);
        treeMap.put(q4, 1);
        treeMap.put(q3, 2);
        treeMap.put(q2, 3);
        treeMap.put(q1, 4);
        treeMap.put(q, 5);
        System.out.println(treeMap);
        int i=10;
        int j = ++i + ++i;
        System.out.println("j: "+j);
    }
}
