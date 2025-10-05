/**ArrayDeque class creates an array that intakes and outtakes
 * at the front and the back.
 * @param <E> eeeee templated
 */
public class ArrayDeque<E> implements Deque<E> {
    /**Queue. */
    private E[] array;
    /**Tracks top of the queue. */
    private int t;
    /**Tracks bottom of the queue. */
    private int b;
    /**Tracks size of queue. */
    private int size;

    //Constructors
    /** Default constructor. */
    public ArrayDeque() {
        this.array = (E[]) new Object[100];
        this.t = -1;
        this.b = -1;
        this.size = 0;
    }
    /** 
     * Customized constructor.
     * @param capazity Max capacity
     */

    public ArrayDeque(int capazity) {
        this.array = (E[]) new Object[capazity];
        this.t = -1;
        this.b = -1;
        this.size = 0;
    }

    //Methods
    /**
     * Returns the number of elements in the dequeu.
     * @return number of elements in the dequeu
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the dequeu is empty.
     * @return true if the dequeu is empty, false otherwise
     */
    public boolean isEmpty() {
        return t == -1 && b == -1;
    }

    /**
     * Returns, but does not remove, the first element of the dequeu.
     * @return top element in the dequeu (or null if empty)
     */
    public E first() {
        if (t != -1) {
            return array[t];
        }
        else {
            return null;
        }
    }

    /**
     * Returns, but does not remove, the last element of the dequeu.
     * @return top element in the dequeu (or null if empty)
     */
    public E last() {
        if (b != -1) {
            return array[b];
        }
        else {
            return null;
        }
    }

    /**
     * Inserts an element at the front of the dequeu.
     * @param e the element to be inserted
     */
    public void addFirst(E e) {
        if (size() == array.length) {
            throw new RuntimeException("Capacity reached");
        }
        else {
            t = (t - 1 + array.length) % array.length;
            array[t] = e;
            size++;
        }
    }

    /**
     * Inserts an element at the back of the dequeu.
     * @param e the element to be inserted
     */
    public void addLast(E e) {
        if (size() == array.length) {
            throw new RuntimeException("Capacity reached");
        }
        else {
            b = (b + 1) % array.length;
            array[b] = e;
            size++;
        }
    }

    /**
     * Removes and returns the first element of the dequeu (null if empty).
     * @return the first element in the dequeu (or null if empty)
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        else {
            size--;
            int tt = t; // temporary t
            t = (t + 1) % array.length;
            return array[tt];
        }
    }

    /**
     * Removes and returns the last element of the dequeu (null if empty).
     * @return the last element in the dequeu (or null if empty)
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        else {
            size--;
            int bb = b; // temporary b
            b = (b - 1 + array.length) % array.length;
            return array[bb];
        }
    }
}
