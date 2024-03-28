package exercises.exercises3b;

public abstract class Shape {
    public static String color = "";
    public static String boundaryStyle = "";

    // Abstract
    public abstract double calculateArea();
    public abstract double calculatePerimeter();


    public static void setBoundaryStyle(String newboundaryStyle) {
        boundaryStyle = newboundaryStyle;
    }
    public static void setColor(String newColor) {
        color = newColor;
    }
}
