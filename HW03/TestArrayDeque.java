import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**Class to test ArrayDeque. */
public class TestArrayDeque {
    /**
     * Checks size of ArrayDeque.
     */
    @Test
    public void testSize() {
        ArrayDeque<Integer> array = new ArrayDeque<Integer>();
        array.addFirst(36);
        array.addLast(42);
        assertEquals(2, array.size());
    }

    /**
     * Checks if ArrayDeque is empty.
     */
    @Test
    public void isEmpty() {
        ArrayDeque<String> array1 = new ArrayDeque<String>();
        ArrayDeque<String> array2 = new ArrayDeque<String>();
        array1.addFirst("a");
        array1.addLast("b");
        assertEquals(false, array1.isEmpty());
        assertEquals(true, array2.isEmpty());
    }

    /**
     * Checks the first element of ArrayDeque.
     */
    @Test
    public void testFirst() {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addFirst("a");
        array.addLast("b");
        assertEquals("a", array.first());
    }

    /**
     * Checks the last element of ArrayDeque.
     */
    @Test
    public void testLast() {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addFirst("a");
        array.addLast("b");
        assertEquals("b", array.last());
    }

    /**
     * Checks if the new element is added to the front of ArrayDeque.
     */
    @Test
    public void testAddFirst() throws RuntimeException {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addFirst("b");
        array.addLast("c");
        array.addFirst("a");
        assertEquals("a", array.first());
    }

    /**
     * Checks if the new element is added to the end of ArrayDeque.
     */
    @Test
    public void testAddLast() throws RuntimeException {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addFirst("b");
        array.addLast("c");
        array.addFirst("a");
        assertEquals("c", array.last());
    }
    
    /**
     * Removes and returns the first element of ArrayDeque.
     */
    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addFirst("b");
        array.addLast("c");
        array.addLast("a");
        assertEquals("b", array.removeFirst());
        //assertEquals("c", array.removeFirst());
        //assertEquals("a", array.removeFirst());
    }

    /**
     * Removes and returns the last element of ArrayDeque.
     */
    @Test
    public void testRemoveLast() {
        ArrayDeque<String> array = new ArrayDeque<String>();
        array.addLast("b");
        array.addLast("c");
        array.addFirst("a");
        assertEquals("c", array.removeLast());
        //assertEquals("b", array.removeLast());
        //assertEquals("a", array.removeLast());
    }
}
