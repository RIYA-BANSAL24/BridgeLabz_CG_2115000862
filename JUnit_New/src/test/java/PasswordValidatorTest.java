import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {
    private PasswordValidator passwordValidator;

    @BeforeEach
    void setUp() {
        passwordValidator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(passwordValidator.isValid("Password1"), "Valid password should return true");
    }

    @Test
    void testShortPassword() {
        assertFalse(passwordValidator.isValid("Pass1"), "Password shorter than 8 characters should be invalid");
    }

    @Test
    void testNoUppercasePassword() {
        assertFalse(passwordValidator.isValid("password1"), "Password without uppercase letter should be invalid");
    }

    @Test
    void testNoDigitPassword() {
        assertFalse(passwordValidator.isValid("Password"), "Password without a digit should be invalid");
    }

    @Test
    void testNullPassword() {
        assertFalse(passwordValidator.isValid(null), "Null password should be invalid");
    }
}