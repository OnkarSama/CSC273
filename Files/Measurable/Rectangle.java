
/**
 * Implementation of a measurable rectangle
 */
public class Rectangle implements Measurable
{
    private double width;
    private double height;
    
    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }
    
    public Rectangle()
    {
        width = 1;
        height = 1;
    }
    
    public double getArea()
    {
        return height * width;
    }
    
    public double getPerimeter()
    {
        return (2 * height) + (2 * width);
    }
    
}
