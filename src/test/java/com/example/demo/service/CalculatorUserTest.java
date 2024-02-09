package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class Calculator {
    public void add(int a, int b) {
        // Some implementation that doesn't return a value
    }
}

class CalculatorUser {
    private Calculator calculator;

    public CalculatorUser(Calculator calculator) {
        this.calculator = calculator;
    }

    public int performAddition(int a, int b) {
        // Some logic here
        calculator.add(a, b);
        // More logic...
        return a + b;
    }
}

public class CalculatorUserTest {

    @Test
    public void testPerformAddition() {
        // Create a mock of the Calculator class
        Calculator mockCalculator = mock(Calculator.class);

        // Fix: Stub the void method with doNothing()
        doNothing().when(mockCalculator).add(2, 3);

        // Create an instance of CalculatorUser with the mockCalculator
        CalculatorUser calculatorUser = new CalculatorUser(mockCalculator);

        // Perform the test
        int result = calculatorUser.performAddition(2, 3);

        // Verify that the add method was called with the expected arguments
        verify(mockCalculator).add(2, 3);

        // Verify the result of the performAddition method
        // (In a real scenario, this might be a more meaningful assertion)
        assertEquals(5, result);
    }

    public static void main(String[] args) {
        // Run the test
        CalculatorUserTest test = new CalculatorUserTest();
        test.testPerformAddition();
    }
}
