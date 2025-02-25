import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class ListManagerTest {
    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>();

    }

    @Test
    void addElement() {
        listManager.addElement(testList, 5);
        assertEquals(1, testList.size());
        assertTrue(testList.contains(5));

        listManager.addElement(testList, 10);
        assertEquals(2, testList.size());
        assertTrue(testList.contains(10));
    }

    @Test
    void removeElement() {
        testList.add(5);
        testList.add(10);

        listManager.removeElement(testList, 5);
        assertEquals(1, testList.size());
        assertFalse(testList.contains(5));

        listManager.removeElement(testList, 10);
        assertEquals(0, testList.size());
    }

    @Test
    void getSize() {
        assertEquals(0, listManager.getSize(testList));

        testList.add(1);
        testList.add(2);
        assertEquals(2, listManager.getSize(testList));
    }
}