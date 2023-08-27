package TA30test;

import TA30.CalculatorApp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculatorTest {


    @Test
    public void testAddition() {
        CalculatorApp.evaluateExpression("5+3");
        assertEquals("8.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testSubtraction() {
        CalculatorApp.evaluateExpression("10-4");
        assertEquals("6.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testMultiplication() {
        CalculatorApp.evaluateExpression("6*4");
        assertEquals("24.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testDivision() {
        CalculatorApp.evaluateExpression("15/3");
        assertEquals("5.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testExponentiation() {
        CalculatorApp.evaluateExpression("2^3");
        assertEquals("8.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testModulus() {
        CalculatorApp.evaluateExpression("11%3");
        assertEquals("2.0", CalculatorApp.resultField.getText());
    }

    @Test
    public void testInvalidInput() {
        CalculatorApp.evaluateExpression("invalid");
        assertEquals("Error: Invalid input", CalculatorApp.resultField.getText());
    }
}