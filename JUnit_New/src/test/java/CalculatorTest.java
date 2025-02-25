import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void add() {
        assertEquals(10, calculator.add(6, 4));
        assertEquals(-2, calculator.add(-5, 3));
    }

    @Test
    void subtract() {
        assertEquals(5, calculator.subtract(10, 5));
        assertEquals(-8, calculator.subtract(-5, 3));
    }

    @Test
    void multiply() {
        assertEquals(20, calculator.multiply(5, 4));
        assertEquals(0, calculator.multiply(0, 5));
    }

    @Test
    void divide() {
        assertEquals(5, calculator.divide(10, 2));
        assertEquals(-4, calculator.divide(-8, 2));
    }
    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}