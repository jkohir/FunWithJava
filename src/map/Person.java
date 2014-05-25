/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import java.util.Arrays;

/**
 *
 * @author jkohir
 */
public final class Person
  extends Object
{
   String name;
   int age;
  
  public Person(String name, int age) {
    super();
    this.name = Person.validName(name);
    this.age  = Person.validAge(age);
  }
  
  public Person(String name, String age) {
    this( name, Integer.parseInt(age.trim()) );
  }
  
  private static final int validAge(int age) {
    if (age < 0 || age > 125)
     throw new IllegalArgumentException(
      "invalid age");
    return age;
  }
  
  private static final String validName(String name) {
    if (name == null)
     throw new IllegalArgumentException(
      "name cannot be null");
    name = name.trim();
    if (name.length() == 0)
     throw new IllegalArgumentException(
      "name cannot be blank");
    return name;
  }
  
  protected boolean canEqual(Object other) {
    return other instanceof Person;
  }
  
  @Override
  public boolean equals(Object other) {
    if (this == other)
      return true;
    if ( ! this.canEqual(other) )
      return false;
    Person that = (Person) other;
    if ( ! that.canEqual(this) )
      return false;
    return this.name.equals(that.name)
      && this.age == that.age;
//      return true;
//      return false;
  }
  
  @Override
  public int hashCode() {
    return Arrays.hashCode(
    new Object[] {name, age} );
//      return 42;
  }
  
  @Override
  public String toString() {
    return name + ";" + age;
  }
}
