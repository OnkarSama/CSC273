
/**
 * Write a description of interface Pairable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Pairable<T>
{
    public T getFirst();
    public T getSecond();
    
    public void changeOrder();
}
