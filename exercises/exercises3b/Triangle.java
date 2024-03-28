package exercises.exercises3b;

import java.io.Serializable;

public class Triangle extends Shape implements Serializable {
    private static final long serialVersionUID = 1L;
    private double side_a, side_b, side_c;

    public Triangle(double side_a, double side_b, double side_c) {
        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;
    }

    @Override
    public double calculateArea() {
        double s = (side_a + side_b + side_c) / 2;
        return Math.sqrt(s * (s - side_a) * (s - side_b) * (s - side_c));
    }

    @Override
    public double calculatePerimeter() {
        return side_a + side_b + side_c;
    }
}
