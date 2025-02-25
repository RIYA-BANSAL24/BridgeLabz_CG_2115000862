import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.jupiter.api.Assertions.*;

class PerformanceUtilsTest {
    private final PerformanceUtils taskManager = new PerformanceUtils();

    @Test
    @Timeout(5)
    void testLongRunningTaskTimeout() {
        try {
            assertEquals("Task Completed", taskManager.longRunningTask(), "Task should complete within 5 seconds");
        } catch (InterruptedException e) {
            fail("Test failed due to unexpected interruption: " + e.getMessage());
        }
    }
}
