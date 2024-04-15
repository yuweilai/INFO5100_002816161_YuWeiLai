package org.openjfx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CalculatorApp extends Application {

    private Label resultLabel;
    private double operand1 = 0;
    private double operand2 = 0;
    private char operator = ' ';

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator App");
    
        // Create a BorderPane to hold the UI components
        BorderPane borderPane = new BorderPane();
    
        // Create and configure the result label
        resultLabel = new Label("0");
        resultLabel.setStyle("-fx-font-size: 36px;");
        resultLabel.setPadding(new Insets(10));
        resultLabel.setMaxWidth(Double.MAX_VALUE);
        resultLabel.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        borderPane.setTop(resultLabel);
    
        // Create a GridPane to hold number buttons and operator buttons
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);
    
        // Create number buttons and add them to the grid
        for (int i = 0; i < 10; i++) {
            Button numberButton = new Button(Integer.toString(i));
            numberButton.setOnAction(e -> handleNumber(Integer.parseInt(numberButton.getText())));
            grid.add(numberButton, i % 3, i / 3 + 1);
        }
    
        // Create operator buttons 
        Button plusButton = new Button("+");
        plusButton.setOnAction(e -> handleOperator('+'));
        Button minusButton = new Button("-");
        minusButton.setOnAction(e -> handleOperator('-'));
        Button multiplyButton = new Button("*");
        multiplyButton.setOnAction(e -> handleOperator('*'));
        Button divideButton = new Button("/");
        divideButton.setOnAction(e -> handleOperator('/'));
        Button equalsButton = new Button("=");
        equalsButton.setOnAction(e -> calculateResult());
    
        // Create a button for clearing the result
        Button clearButton = new Button("C");
        clearButton.setOnAction(e -> {
            resultLabel.setText("0");
            operand1 = 0;
            operand2 = 0;
            operator = ' ';
        });
    
        // Add all buttons to the grid
        grid.add(plusButton, 3, 1);
        grid.add(minusButton, 3, 2);
        grid.add(multiplyButton, 3, 3);
        grid.add(divideButton, 3, 4);
        grid.add(equalsButton, 4, 1, 1, 4);
        grid.add(clearButton, 4, 1);
    
        // Create a VBox to hold the grid layout
        VBox vbox = new VBox();
        vbox.getChildren().addAll(grid);
        borderPane.setCenter(vbox);
    
        // Create a Scene and set it to the stage
        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to handle number button clicks
    private void handleNumber(int number) {
        String currentText = resultLabel.getText();
        if (currentText.equals("0")) {
            resultLabel.setText(Integer.toString(number));
        } else {
            resultLabel.setText(currentText + number);
        }
    }

    // Method to handle operator button clicks
    private void handleOperator(char op) {
        operator = op;
        operand1 = Double.parseDouble(resultLabel.getText());
        resultLabel.setText("0");
    }

    // Method to calculate the result of the operation
    private void calculateResult() {
        operand2 = Double.parseDouble(resultLabel.getText());
        double result = 0;
        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    resultLabel.setText("Zero Division Error. Try Again.");
                    return;
                }
                break;
        }
        resultLabel.setText(Double.toString(result));
    }

    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
