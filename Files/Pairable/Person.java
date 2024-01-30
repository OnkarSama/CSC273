
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;
    private int age;
    
    public Person(String n, int a)
    {
        name = n;
        age = a;
    }
    
    public String toString()
    {
        return name + ", " + age;
    }
}
