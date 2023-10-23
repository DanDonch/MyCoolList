import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class MyCoolListTest {
    private MyCoolList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyCoolList<>(); // Инициализация списка перед каждым тестом
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void testAdd() {
        list.add(4);
        assertEquals(4, list.size());
        assertEquals(Integer.valueOf(4), list.get(3));
    }

    @Test
    void testGet() {
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }

    @Test
    void testGetInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    @Test
    void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    void testRemove() {
        assertTrue(list.remove(Integer.valueOf(2));
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    void testRemoveInvalidElement() {
        assertFalse(list.remove(Integer.valueOf(4));
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveByIndex() {
        Integer removed = list.remove(1);
        assertEquals(Integer.valueOf(2), removed);
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveByInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    void testToArray() {
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(Integer.valueOf(1), array[0]);
        assertEquals(Integer.valueOf(2), array[1]);
        assertEquals(Integer.valueOf(3), array[2]);
    }

    @Test
    void testIsEmpty() {
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void testClear() {
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testContains() {
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    void testSubList() {
        MyCoolList<Integer> subList = list.subList(1, 3);
        assertEquals(2, subList.size());
        assertEquals(Integer.valueOf(2), subList.get(0));
        assertEquals(Integer.valueOf(3), subList.get(1));
    }

    @Test
    void testSubListInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.subList(2, 1));
    }

    @Test
    void testIterator() {
        int expectedValue = 1;
        for (Integer value : list) {
            assertEquals(Integer.valueOf(expectedValue), value);
            expectedValue++;
        }
    }

    @Test
    void testIteratorNoMoreElements() {
        assertThrows(NoSuchElementException.class, () -> {
            for (int i = 0; i <= list.size(); i++) {
                list.iterator().next();
            }
        });
    }
}
