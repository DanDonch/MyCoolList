import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyCoolListTest {
    public MyCoolList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyCoolList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    void testAdd() {
        list.add(4);
        assertEquals(4, list.size());
        assertEquals(4, list.get(3));
    }

    @Test
    void testGet() {
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    void testGetInvalidIndex() {
        try {
            list.get(3);
            fail("IndexOutOfBoundsException was not thrown.");
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveByObject() {
        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertEquals(3, list.get(1));
    }

    @Test
    void testRemoveInvalidObject() {
        assertFalse(list.remove(Integer.valueOf(4)));
        assertEquals(3, list.size());
    }

    @Test
    void testRemoveByIndex() {
        Integer removed = list.remove(1);
        assertEquals(2, removed);
        assertEquals(2, list.size());
    }

    @Test
    void testRemoveByInvalidIndex() {
        try {
            list.remove(3);
            fail("IndexOutOfBoundsException was not thrown.");
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    void testToArray() {
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(2, array[1]);
        assertEquals(3, array[2]);
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
        assertEquals(2, subList.get(0));
        assertEquals(3, subList.get(1));
    }

    @Test
    void testSubListInvalidIndex() {
        try {
            list.subList(2, 1);
            fail("IndexOutOfBoundsException was not thrown.");
        } catch (IndexOutOfBoundsException e) {}
    }

    @Test
    void testIterator() {
        int expectedValue = 1;
        for (Integer value : list) {
            assertEquals(Integer.valueOf(expectedValue), value);
            expectedValue++;
        }
    }
}
