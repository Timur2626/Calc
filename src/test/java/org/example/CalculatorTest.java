package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }


    @Test
    void addPositive() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void addNegative() {
        assertEquals(-5, calc.add(-2, -3));
    }

    @Test
    void addZero() {
        assertEquals(0, calc.add(0, 0));
    }

    @Test
    void addPositiveAndNegative() {
        assertEquals(0, calc.add(-5, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "1,      2,      3",
            "-1,    -2,     -3",
            "0,      0,      0",
            "1.5,    2.5,    4.0",
            "-5,     5,      0",
            "1e10,   1e10,   2e10",
            "1e-10,  1e-10,  2e-10"
    })
    void addParameterized(double a, double b, double expected) {
        assertEquals(expected, calc.add(a, b), 1e-9);
    }


    @Test
    void subtractPositive() {
        assertEquals(2, calc.subtract(5, 3));
    }

    @Test
    void subtractNegative() {
        assertEquals(-2, calc.subtract(-5, -3));
    }

    @Test
    void subtractZero() {
        assertEquals(0, calc.subtract(0, 0));
    }

    @Test
    void subtractBiggerFromSmaller() {
        assertEquals(-2, calc.subtract(3, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "5,      3,      2",
            "-5,    -3,     -2",
            "0,      0,      0",
            "3,      5,     -2",
            "1e10,   1e10,   0",
            "0.3,    0.1,    0.2"
    })
    void subtractParameterized(double a, double b, double expected) {
        assertEquals(expected, calc.subtract(a, b), 1e-9);
    }


    @Test
    void multiplyPositive() {
        assertEquals(6, calc.multiply(2, 3));
    }

    @Test
    void multiplyPositiveByNegative() {
        assertEquals(-6, calc.multiply(-2, 3));
    }

    @Test
    void multiplyNegativeByNegative() {
        assertEquals(6, calc.multiply(-2, -3));
    }

    @Test
    void multiplyByZero() {
        assertEquals(0, calc.multiply(100, 0));
    }

    @ParameterizedTest
    @CsvSource({
            "2,      3,      6",
            "-2,     3,     -6",
            "-2,    -3,      6",
            "0,      100,    0",
            "1e5,    1e5,    1e10",
            "0.5,    0.5,    0.25"
    })
    void multiplyParameterized(double a, double b, double expected) {
        assertEquals(expected, calc.multiply(a, b), 1e-9);
    }


    @Test
    void dividePositive() {
        assertEquals(2, calc.divide(6, 3));
    }

    @Test
    void divideNegativeByPositive() {
        assertEquals(-2, calc.divide(-6, 3));
    }

    @Test
    void divideZeroByNumber() {
        assertEquals(0, calc.divide(0, 5));
    }

    @ParameterizedTest
    @CsvSource({
            "6,      3,      2",
            "-6,     3,     -2",
            "0,      5,      0",
            "1,      3,      0.333333333",
            "-9,    -3,      3",
            "1e10,   1e5,    1e5"
    })
    void divideParameterized(double a, double b, double expected) {
        assertEquals(expected, calc.divide(a, b), 1e-9);
    }


    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @Test
    void divideZeroByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> calc.divide(0, 0));
    }


    @Test
    @Disabled
    void thisTestFailsOnPurpose() {
        assertEquals(5, calc.add(2, 2));
    }

    @Test
    @Disabled
    void thisTestAlsoFailsOnPurpose() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 2));
    }
}