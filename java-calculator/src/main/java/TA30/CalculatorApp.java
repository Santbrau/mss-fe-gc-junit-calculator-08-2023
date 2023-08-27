package TA30;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {
    public static JTextField inputField;
    public static JTextField resultField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Calculator");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create GUI components
                inputField = new JTextField(15);
                resultField = new JTextField(15);
                resultField.setEditable(false);

                JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

                // Create number buttons
                for (int i = 1; i <= 9; i++) {
                    addButton(buttonPanel, String.valueOf(i));
                }

                addButton(buttonPanel, "0");
                addButton(buttonPanel, "+");
                addButton(buttonPanel, "-");
                addButton(buttonPanel, "*");
                addButton(buttonPanel, "/");
                addButton(buttonPanel, "^");
                addButton(buttonPanel, "%");
                addButton(buttonPanel, "=");
                addButton(buttonPanel, "C");

                // Layout
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(inputField, BorderLayout.NORTH);
                panel.add(resultField, BorderLayout.CENTER);
                panel.add(buttonPanel, BorderLayout.SOUTH);

                // Add panel to frame
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    public static void addButton(JPanel panel, final String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.equals("=")) {
                    evaluateExpression(inputField.getText());
                } else if (text.equals("C")) {
                    inputField.setText("");
                } else {
                    inputField.setText(inputField.getText() + text);
                }
            }
        });
        panel.add(button);
    }

    public static void evaluateExpression(String expression) {
        try {
        	String[] parts = expression.split("(?=[-+*/^%])|(?<=[-+*/^%])");

            if (parts.length != 3) {
                resultField.setText("Invalid input");
                return;
            }

            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[2]);
            String operator = parts[1];

            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultField.setText("Error: Division by zero");
                        return;
                    }
                    break;
                case "^":
                    result = Math.pow(num1, num2);
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                default:
                    resultField.setText("Invalid operator");
                    return;
            }

            resultField.setText(Double.toString(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Error: Invalid input");
        }
    }

}
