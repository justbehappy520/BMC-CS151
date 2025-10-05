import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * A class to test the methods of ArrayBinaryTree.
 */
public class TestArrayHeap {
    /**
     * Tests the getRootElement method.
     */
    @Test
    public void testGetRootElement() {
        ArrayHeap<String> shu4 = new ArrayHeap<>();
        shu4.insert(":3");
        shu4.insert("^^");

        assertEquals(":3", shu4.getRootElement());

        ArrayHeap<String> namu = new ArrayHeap<>();
        assertEquals(null, namu.getRootElement());
    }

    /**
     * Tests the size method.
     */
    @Test
    public void testSize() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);
        
        assertEquals(3, shu4.size());

        ArrayHeap<String> namu = new ArrayHeap<>();
        assertEquals(0, namu.size());
    }

    /**
     * Tests the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertFalse(shu4.isEmpty());

        ArrayHeap<String> namu = new ArrayHeap<>();
        assertTrue(namu.isEmpty());
    }

    /**
     * Tests the remove method.
     */
    @Test
    public void testRemove() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertTrue(shu4.remove(5));
        assertEquals("0 2", shu4.toStringBreadthFirst());
    }

    /**
     * Tests the toStringBreadthFirst method.
     */
    @Test
    public void testToStringBreadFirst() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals("0 5 2", shu4.toStringBreadthFirst());
    }
    
    /**
     * Tests the peek method.
     */
    @Test
    public void testPeek() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals(Integer.valueOf(0), shu4.peek());
    }

    /**
     * Tests the poll method.
     */
    @Test
    public void testPoll() {
        ArrayHeap<Integer> shu4 = new ArrayHeap<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals(Integer.valueOf(0), shu4.poll());
    }
}
