import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorClassTest {
    CalculatorClass calculator = new CalculatorClass();

    @Test
    void divide() {
        assertEquals(5, calculator.divide(10, 2));
        assertEquals(-4, calculator.divide(-8, 2));
    }
    @Test
    void testDivideByZeroException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}