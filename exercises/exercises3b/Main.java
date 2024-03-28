package exercises.exercises3b;
import exercises.exercises3b.Circle;
import exercises.exercises3b.Rectangle;
import exercises.exercises3b.Shape;
import exercises.exercises3b.Square;
import exercises.exercises3b.Triangle;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create shapes with different dimensions
        Triangle customTriangle = new Triangle(3, 4, 5); 
        Rectangle customRectangle = new Rectangle(2, 4);
        Circle customCircle = new Circle(3); 
        Square customSquare = new Square(4); 

        // Serialize each shape to a file
        serializeShape(customTriangle, "customTriangle.ser");
        serializeShape(customRectangle, "customRectangle.ser");
        serializeShape(customCircle, "customCircle.ser");
        serializeShape(customSquare, "customSquare.ser");

        // Deserialize each shape from a file
        Triangle deserializedTriangle = (Triangle) deserializeShape("customTriangle.ser");
        Rectangle deserializedRectangle = (Rectangle) deserializeShape("customRectangle.ser");
        Circle deserializedCircle = (Circle) deserializeShape("customCircle.ser");
        Square deserializedSquare = (Square) deserializeShape("customSquare.ser");

        // Display the area of each deserialized shape
        displayArea(deserializedTriangle, "Triangle");
        displayArea(deserializedRectangle, "Rectangle");
        displayArea(deserializedCircle, "Circle");
        displayArea(deserializedSquare, "Square");
    }

    // Method to serialize a shape to a file
    private static void serializeShape(Object shape, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(shape);
            System.out.println("Serialization: Shape saved as '" + fileName + "'");
        } catch (IOException e) {
            System.err.println("Serialization Error: Failed to save Shape to file '" + fileName + "'");
            e.printStackTrace();
        }
    }

    // Method to deserialize a shape from a file
    private static Object deserializeShape(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Object shape = in.readObject();
            System.out.println("Deserialization: Shape loaded from '" + fileName + "'");
            return shape;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization Error: Failed to load Shape from file '" + fileName + "'");
            e.printStackTrace();
            return null;
        }
    }

    // Method to display the area of a shape
    private static void displayArea(Shape shape, String shapeName) {
        if (shape != null) {
            double area = shape.calculateArea();
            System.out.println("Area of " + shapeName + ": " + area);
        } else {
            System.out.println("Failed to calculate area of " + shapeName + ". Shape object is null.");
        }
    }
}
