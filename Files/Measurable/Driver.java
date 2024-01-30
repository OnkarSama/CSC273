
/**
 * Driver for Measurable interface implementations
 */
public class Driver
{
    public static void main(String[] args)
    {
        Measurable shape;
        
        //create a shape
        //shape = new Rectangle(4.7, 3.2);
        shape = new Circle(2.5);
        
        double peri = shape.getPerimeter();
        double area = shape.getArea();
        
        System.out.println("Perimeter = " + peri + ", Area = " + area);
    }
}
