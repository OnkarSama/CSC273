
/**
 * OrderdPair.java
 * 
 * Class representing an ordered pair of unspecified objects
 */
public class OrderedPair<T> implements Pairable<T>
{
    private T first;
    private T second;
    
    public OrderedPair(T firstItem, T secondItem)
    {
        first = firstItem;
        second = secondItem;
    }
    
    //getFirst() - returns the first item
    public T getFirst()
    {
        return first;
    }
    
    //getSecond() - returns the second item
    public T getSecond()
    {
        return second;
    }
    
    //changeOrder() - swaps order of two items
    public void changeOrder()
    {
        T temp = first;
        first = second;
        second = temp;
    }
    
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
}
