import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * A class to test the methods of ArrayBinaryTree.
 */
public class TestArrayBinaryTree {
    /**
     * Tests the getRootElement method.
     */
    @Test
    public void testGetRootElement() {
        ArrayBinaryTree<String> shu4 = new ArrayBinaryTree<>();
        shu4.insert(":3");
        shu4.insert("^^");

        assertEquals(":3", shu4.getRootElement());

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
        assertEquals(null, namu.getRootElement());
    }

    /**
     * Tests the size method.
     */
    @Test
    public void testSize() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);
        
        assertEquals(3, shu4.size());

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
        assertEquals(0, namu.size());
    }

    /**
     * Tests the isEmpty method.
     */
    @Test
    public void testIsEmpty() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertFalse(shu4.isEmpty());

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
        assertTrue(namu.isEmpty());
    }

    /**
     * Tests the parent method.
     */
    @Test
    public void testParent() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals(0, shu4.parent(1));
        assertEquals(0, shu4.parent(2));

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
    }

    /**
     * Tests the left method.
     */
    @Test
    public void testLeft() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals(1, shu4.left(0));

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
    }

    /**
     * Tests the right method.
     */
    @Test
    public void testRight() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertEquals(2, shu4.right(0));

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
    }

    /**
     * Tests the swap method.
     */
    @Test
    public void testSwap() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        shu4.swap(0, 1);
        assertEquals(Integer.valueOf(2), shu4.getRootElement());

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
    }

    /**
     * Tests the containsIdx method.
     */
    @Test
    public void testContainsIdx() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);
        System.out.println(shu4.toStringBreadthFirst());

        assertEquals(0, shu4.containsIdx(0));
        assertEquals(1, shu4.containsIdx(5));
        assertEquals(2, shu4.containsIdx(2));

        ArrayBinaryTree<String> namu = new ArrayBinaryTree<>();
    }

    /**
     * Tests the remove method.
     */
    @Test
    public void testRemove() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);

        assertTrue(shu4.remove(5));
        assertEquals("2 0", shu4.toStringBreadthFirst());
    }

    /**
     * Tests the toStringBreadthFirst method.
     */
    @Test
    public void testToStringBreadFirst() {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(5);
        shu4.insert(2);
        shu4.insert(0);
        System.out.println(shu4.toStringBreadthFirst());

        assertEquals("5 2 0", shu4.toStringBreadthFirst());
    }
    
}
