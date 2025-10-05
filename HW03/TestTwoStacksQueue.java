import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**Class to test TwoStacksQueue. */
public class TestTwoStacksQueue {
    /**
     * Checks size of TwoStacksQueue object.
     */
    @Test
    public void testSize() {
        TwoStacksQueue<String> queue = new TwoStacksQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals(2, queue.size());
    }

    /**
     * Checks if the TwoStacksQueue object is empty.
     */
    @Test
    public void testIsEmpty() {
        TwoStacksQueue<String> queue1 = new TwoStacksQueue<String>();
        TwoStacksQueue<String> queue2 = new TwoStacksQueue<String>();
        queue1.enqueue("a");
        queue1.enqueue("b");
        assertEquals(false, queue1.isEmpty());
        assertEquals(true, queue2.isEmpty());
    }

    /**
     * Checks the enqueue'd element in the TwoStacksQueue object.
     */
    @Test
    public void testEnqueue() {
        TwoStacksQueue<String> queue = new TwoStacksQueue<String>();
        queue.enqueue("a");
        assertEquals("a", queue.first());
    }

    /**
     * Checks the first element in the TwoStacksQueue object.
     */
    @Test
    public void testFirst() {
        TwoStacksQueue<String> queue = new TwoStacksQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals("a", queue.first());
    }

    /**
     * Checks dequeue'd object from the TwoStacksQueue.
     */
    @Test
    public void testDequeue() {
        TwoStacksQueue<String> queue = new TwoStacksQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals("a", queue.dequeue());
    }

    /**
     * Checks printed elements of the TwoStacksQueue.
     */
    @Test
    public void testString() {
        TwoStacksQueue<String> queue = new TwoStacksQueue<String>();
        queue.enqueue("a");
        queue.enqueue("b");
        assertEquals("(a, b)", queue.toString());
    }
}
