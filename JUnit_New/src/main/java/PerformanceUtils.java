public class PerformanceUtils {
    public String longRunningTask() throws InterruptedException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}