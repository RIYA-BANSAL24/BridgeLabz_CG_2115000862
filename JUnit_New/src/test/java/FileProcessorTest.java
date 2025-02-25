import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {
    private FileProcessor fileProcessor;
    private final String testFile = "testFile.txt";

    @BeforeEach
    void setUp() {
        fileProcessor = new FileProcessor();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(testFile));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        fileProcessor.writeToFile(testFile, content);

        String readContent = fileProcessor.readFromFile(testFile);
        assertEquals(content, readContent, "Content should match after reading from file");
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        fileProcessor.writeToFile(testFile, "Sample content");
        assertTrue(Files.exists(Path.of(testFile)), "File should exist after writing");
    }

    @Test
    void testReadFromNonExistentFileThrowsIOException() {
        Exception exception = assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        assertTrue(exception.getMessage().contains("nonexistent.txt"), "Exception message should indicate missing file");
    }
}