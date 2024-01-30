
/**
 * Driver for Measurable interface implementations
 */
public class Driver
{
    public static void main(String[] args)
    {
        Measurable circle;
        Measurable rectangle;

        //create a shape
        rectangle = new Rectangle(4.7, 3.2);
        circle = new Circle(2.5);

        double circlePeri = circle.getPerimeter();
        double circleArea = circle.getArea();

        System.out.println("Perimeter = " + circlePeri + ", Area = " + circleArea);

        double rectanglePeri = rectangle.getPerimeter();
        double rectangleArea = rectangle.getArea();

        System.out.println("Perimeter = " + rectanglePeri + ", Area = " + rectangleArea);
    }
}