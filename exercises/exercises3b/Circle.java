package exercises.exercises3b;

import java.io.Serializable;

public class Circle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}