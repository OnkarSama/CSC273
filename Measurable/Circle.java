
/**
 * Implementation of a measurable circle
 */
public class Circle implements Measurable
{
    private double radius;

    public Circle(double r)
    {
        radius = r;
    }

    public Circle()
    {
        radius = 1.0;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
}