package org.openjfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class App extends Application {

    private Canvas canvas;
    private GraphicsContext gc;
    private Label digitLabel;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 450); // Increased height to accommodate label

        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(5);
        gc.setStroke(Color.BLACK);

        digitLabel = new Label(""); // Initialize label
        digitLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");
        root.setBottom(digitLabel); // Add label to the bottom of the BorderPane

        canvas.setOnMousePressed(e -> {
            gc.beginPath();
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });

        canvas.setOnMouseDragged(e -> {
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        });

        canvas.setOnMouseReleased(e -> {
            // Save the drawn image
            File imageFile = new File("drawn_digit.png");
            saveImage(imageFile);

            // Run the Python TensorFlow script to recognize the digit
            try {
                ProcessBuilder pb = new ProcessBuilder("python", "recognize_digit.py", imageFile.getAbsolutePath());
                Process process = pb.start();

                // Read the output of the Python script
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    // Successfully recognized digit, display the result
                    String recognizedDigit = readResult(process);
                    System.out.println("Recognized digit: " + recognizedDigit);
                    digitLabel.setText("Recognized digit: " + recognizedDigit); // Update label text
                } else {
                    System.err.println("Error running Python script.");
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        root.setCenter(canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Number Draw");
        primaryStage.show();
    }

    private void saveImage(File file) {
        // Create a WritableImage from the canvas
        WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
        SnapshotParameters parameters = new SnapshotParameters();
        // parameters.setFill(Color.TRANSPARENT); // Set background to transparent
        canvas.snapshot(parameters, writableImage);
    
        // Write the WritableImage to the specified file
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
            System.out.println("Image saved successfully to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String readResult(Process process) throws IOException {
        // Read the output of the Python script from the process's input stream
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            // Filter out unwanted information
            if (line.startsWith("Recognized digit:")) {
                result.append(line.substring("Recognized digit:".length()).trim());
                break; // Stop reading after finding the recognized digit
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
