
/**
 * Write a description of class Recursion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recursion
{
    public static void main(String[] args)
    {
        foo(5);

    }

    public static void foo(int i)
    {
        if (i > 0)
            foo(i - 1);

        System.out.println("Calling foo on i: " + i);
    }

    //MAIN()
}