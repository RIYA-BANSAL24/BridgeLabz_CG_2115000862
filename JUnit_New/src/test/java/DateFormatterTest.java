import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    void testValidDateFormat() {
        assertEquals("25-12-2023", dateFormatter.formatDate("2023-12-25"), "Date should be formatted correctly");
        assertEquals("01-01-2024", dateFormatter.formatDate("2024-01-01"), "Date should be formatted correctly");
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate("25-12-2023"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testInvalidCharactersInDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate("abcd-ef-gh"));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

    @Test
    void testEmptyDateString() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> dateFormatter.formatDate(""));
        assertEquals("Invalid date format. Expected yyyy-MM-dd.", exception.getMessage());
    }

}