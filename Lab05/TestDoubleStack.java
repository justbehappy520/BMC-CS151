import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.beans.Transient;

/** Class that tests the DoubleStack. **/
public class TestDoubleStack {
    @Test
    public void testPop() throws DoubleStack.IllegalStateException,
        DoubleStack.IllegalArgumentException {
        DoubleStack<Integer> dStack = new DoubleStack<Integer>();
        dStack.push(1, 5);
        dStack.push(2, 7);
        dStack.push(1, 100);
        dStack.push(2, 1029);
        int check1 = dStack.pop(1);
        int check2 = dStack.pop(2);
        assertEquals(check1, dStack.pop(1));
        assertEquals(check2, dStack.pop(2));
    }

    @Test
    public void testTop() throws DoubleStack.IllegalStateException,
        DoubleStack.IllegalArgumentException {
        DoubleStack<Integer> dStack = new DoubleStack<Integer>();
        dStack.push(1, 5);
        dStack.push(2, 7);
        dStack.push(1, 100);
        dStack.push(2, 1029);
        int check1 = dStack.top(1);
        int check2 = dStack.top(2);
        assertEquals(check1, dStack.top(1));
        assertEquals(check2, dStack.top(2));
    }

    @Test
    public void testSize() throws DoubleStack.IllegalStateException,
        DoubleStack.IllegalArgumentException {
        DoubleStack<Integer> dStack = new DoubleStack<Integer>();
        dStack.push(1, 5);
        dStack.push(2, 7);
        dStack.push(1, 100);
        dStack.push(2, 1029);
        int check1 = dStack.size(1);
        int check2 = dStack.size(2);
        assertEquals(check1, dStack.size(1));
        assertEquals(check2, dStack.size(2));
    }

    @Test
    public void testIsEmpty() throws DoubleStack.IllegalStateException,
        DoubleStack.IllegalArgumentException {
        DoubleStack<Integer> dStack = new DoubleStack<Integer>();
        dStack.push(1, 5);
        dStack.push(1, 100);
        boolean check1 = dStack.isEmpty(1);
        boolean check2 = dStack.isEmpty(2);
        assertEquals(check1, dStack.isEmpty(1));
        assertEquals(check2, dStack.isEmpty(2));
    }

    @Test
    public void testPrintStack() throws DoubleStack.IllegalStateException,
        DoubleStack.IllegalArgumentException {
        DoubleStack<Integer> dStack = new DoubleStack<Integer>();
        dStack.push(1, 5);
        dStack.push(2, 7);
        dStack.push(1, 100);
        dStack.push(2, 1029);
        String check1 = dStack.printStack(1);
        String check2 = dStack.printStack(2);
        assertEquals(check1, dStack.printStack(1));
        assertEquals(check2, dStack.printStack(2));
    }
}
