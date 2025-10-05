import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Class that tests ArrayIterator. */
public class TestIterator {
    /** Checks if hasNext() works as expected.
     * @result true For itr1 because there is next
     * @result false For itr2 because there is no next
     */
    @Test
    public void testHasNext() {
        //create ArrayList
        ArrayList<String> test1 = new ArrayList<String>();
        test1.add(0, "p");
        test1.add(0, "o");
        test1.add(0, "t");

        ArrayList<Integer> test2 = new ArrayList<Integer>();

        //create Iterator
        Iterator<String> itr1 = test1.iterator();
        Iterator<Integer> itr2 = test2.iterator();
        
        //verify Iterator
        assertTrue(itr1.hasNext());
        itr1.next();
        assertTrue(itr1.hasNext());
        itr1.next();
        assertTrue(itr1.hasNext());
        itr1.next();
        assertFalse(itr1.hasNext());

        assertFalse(itr2.hasNext());
    }

    /** Checks if next() works as expected.
     * @result t First elem
     * @result o Second elem
     * @result p Third elem
     * @throws NoSuchElementException if there is no next element
    */
    @Test
    public void testNext() {
        //create new ArrayList
        ArrayList<String> test = new ArrayList<String>();
        test.add(0, "p");
        test.add(0, "o");
        test.add(0, "t");

        //create Iterator
        Iterator<String> itr = test.iterator();

        //verify Iterator
        assertTrue(itr.hasNext());
        assertEquals("t", itr.next());

        assertTrue(itr.hasNext());
        assertEquals("o", itr.next());

        assertTrue(itr.hasNext());
        assertEquals("p", itr.next());

        assertFalse(itr.hasNext());
        assertThrows(NoSuchElementException.class, () -> {
            itr.next();
        });
    }

    /** Checks if remove() works as expected.
     * @result 3 At index 0
     * @result 1 At index 1
     * @throws IllegalStateException when nothing can be removed
     */
    @Test
    public void testRemove() {
        //create new ArrayList
        ArrayList<Integer> test1 = new ArrayList<Integer>();
        test1.add(0, 1);
        test1.add(0, 2);
        test1.add(0, 3);

        ArrayList<Integer> test2 = new ArrayList<Integer>();
        test2.add(0, 520);
        test2.add(0, 1314);

        //create Iterator
        Iterator<Integer> itr1 = test1.iterator();
        Iterator<Integer> itr2 = test2.iterator();

        //run Iterator
        while (itr1.hasNext()) {
            int elem = itr1.next();
            if (elem + 1 == 3) {
                itr1.remove();
            }
        }

        while (itr2.hasNext()) {
            int elem = itr2.next();
            if (elem % 2 == 0) {
                itr2.remove();
            }
        }

        //verify ArrayList
        assertEquals(2, test1.size());
        assertEquals(Integer.valueOf(3), test1.get(0));
        assertEquals(Integer.valueOf(1), test1.get(1));

        assertEquals(0, test2.size());
        assertThrows(IllegalStateException.class, () -> {
            itr2.remove();
        });
    }
}
