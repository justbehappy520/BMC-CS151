/**
 * A collection of objects that are inserted and removed according to the 
 * last-in first-out principle. Although similar in purpose, this interface 
 * differs from java.util.Stack.
 * 
 * Integer version of the textbook Stack.java
 * @author Dianna Xu
 */

public interface IntStack {

    /**
     * Returns the number of elements in the stack.
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an integer at the top of the stack.
     * @param i     the integer to be inserted
     */
    void push(Integer i);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     * @return top element in the stack (or null if empty)
     */
    Integer top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    Integer pop();

    /**
     * Returns, but does not remove, the min element in the stack.
     * @return minimum element in the stack (or null if empty) 
     */
    Integer minElement();
}
