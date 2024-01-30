/**
 * @author Onkar Dhillon
 * Class Representing an ordered pair of unspecified objects.
 */
public class OrderedPair<T> implements Pairable {

    private T first;
    private T second;

    public OrderedPair(T firstItem, T secondItem) {
        this.first = firstItem;
        this.second = secondItem;
    }

    public T getFirst() {
        return this.first;
    }

    public T getSecond() {
        return this.second;
    }

    public void changeOrder() {
        T temp = this.first;
        this.first = this.second;
        this.second = temp;
    }

    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
