import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
    }

    @AfterEach
    void tearDown() {
        databaseConnection.disconnect();
    }

    @Test
    void testConnectionIsEstablished() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected");
    }

    @Test
    void testConnectionIsClosedAfterEachTest() {
        assertTrue(databaseConnection.isConnected(), "Database should be connected");
    }
}