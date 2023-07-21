import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField num1Field;
    private JTextField num2Field;
    private JTextField resultField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        // Create the main window
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(11, 1));

        // Create GUI components
        createComponents();

        // Implement event handling for the buttons
        addEventHandlers();

        // Set up the frame and display the GUI
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents() {
        JLabel num1Label = new JLabel("Enter first number:");
        JLabel num2Label = new JLabel("Enter second number:");
        JLabel resultLabel = new JLabel("Result:");
        num1Field = new JTextField();
        num2Field = new JTextField();
        resultField = new JTextField();
        JButton addButton = new JButton("Add");
        JButton subButton = new JButton("Subtract");
        JButton mulButton = new JButton("Multiply");
        JButton divButton = new JButton("Divide");
        JButton exitButton = new JButton("Exit");

        JPanel exitPanel = new JPanel(new GridLayout(1, 1));
        exitPanel.add(exitButton);

        // Add components to the JFrame using the GridLayout
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(mulButton);
        frame.add(divButton);
        frame.add(exitPanel);
    }

    private void addEventHandlers() {
        for (Component component : frame.getContentPane().getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                switch (button.getText()) {
                    case "Add":
                        button.addActionListener(e -> performOperation("Add"));
                        break;
                    case "Subtract":
                        button.addActionListener(e -> performOperation("Subtract"));
                        break;
                    case "Multiply":
                        button.addActionListener(e -> performOperation("Multiply"));
                        break;
                    case "Divide":
                        button.addActionListener(e -> performOperation("Divide"));
                        break;
                    case "Exit":
                        button.addActionListener(e -> System.exit(0));
                        break;
                }
            }
        }
    }

    private void performOperation(String operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            double result = 0;

            switch (operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
                case "Divide":
                    result = num1 / num2;
                    break;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        } catch (ArithmeticException ex) {
            resultField.setText("Division by zero");
        }
    }
}
