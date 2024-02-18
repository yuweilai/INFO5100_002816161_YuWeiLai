package exercises.exercises2;

public class Main {
    public static void main(String[] args) {
        
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(2, 4);
        Circle circle = new Circle(3);
        Square square = new Square(4);

        // Set color and boundary style for all shapes
        Shape.setColor("Red");
        Shape.setBoundaryStyle("Dotted");

        // Print information for each shape
        System.out.println("Triangle:");
        System.out.println("Color: " + Shape.color);
        System.out.println("Boundary Style: " + Shape.boundaryStyle);
        System.out.println("Area: " + triangle.calculateArea());
        System.out.println("Perimeter: " + triangle.calculatePerimeter());
        System.out.println();

        Rectangle.setColor("Green");
        Rectangle.setBoundaryStyle("Dashed");
        System.out.println("Rectangle:");
        System.out.println("Color: " + Shape.color);
        System.out.println("Boundary Style: " + Shape.boundaryStyle);
        System.out.println("Area: " + rectangle.calculateArea());
        System.out.println("Perimeter: " + rectangle.calculatePerimeter());
        System.out.println();

        Circle.setColor("Blue");
        Circle.setBoundaryStyle("Dashed");
        System.out.println("Circle:");
        System.out.println("Color: " + Shape.color);
        System.out.println("Boundary Style: " + Shape.boundaryStyle);
        System.out.println("Area: " + circle.calculateArea());
        System.out.println("Perimeter: " + circle.calculatePerimeter());
        System.out.println();

        Square.setColor("Yellow");
        Square.setBoundaryStyle("No Style");
        System.out.println("Square:");
        System.out.println("Color: " + Shape.color);
        System.out.println("Boundary Style: " + Shape.boundaryStyle);
        System.out.println("Area: " + square.calculateArea());
        System.out.println("Perimeter: " + square.calculatePerimeter());
    }
}
