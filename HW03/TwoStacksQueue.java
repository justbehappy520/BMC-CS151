/**
 * Creates a queue out of two back to back stacks.
 * @param <E> ??
 */
public class TwoStacksQueue<E> implements Queue<E> {
    private ArrayStack stack1;
    private ArrayStack stack2;

    //Constructors
    /** Default construcator. */
    public TwoStacksQueue() {
        this.stack1 = new ArrayStack(100);
        this.stack2 = new ArrayStack(100);
    }
    /**
     * Customizable constructor.
     * @param capazity Max capacity
     */
    
    public TwoStacksQueue(int capazity) {
        this.stack1 = new ArrayStack(capazity);
        this.stack2 = new ArrayStack(capazity);
    }

    //Methods
    /**
     * Returns the number of elements in the queue.
     * @return number of elements in the queue
     */
    public int size() {
        int size = stack1.size() + stack2.size();
        return size;
    }

    /**
     * Tests whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack1.size() + stack2.size() == 0;
    }

    /**
     * Inserts an element at the rear of the queue.
     * @param e the element to be inserted
     */
    @Override
    public void enqueue(E e) {
        stack1.push(e);
    }

    /**
     * Returns, but does not remove, the first element of the queue.
     * @return top element in the queue (or null if empty)
     */
    public E first() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        return (E) stack2.top();
    }

    /**
     * Removes and returns the first element from the queue.
     * @return element removed (or null if empty)
     */
    public E dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        return (E) stack2.pop();
    }

    /**
     * Returns a string listing all the elements in the TwoStackQueue.
     */
    @Override
    public String toString() {
        String print = "(";
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.top());
                stack1.pop();
            }
        }
        while (!stack2.isEmpty()) {
            print += stack2.top();
            stack2.pop();
            if (!stack2.isEmpty()) {
                print += ", ";
            }
        }
        return print + ")";
    }
}