public class DoubleStack<E> {
    // Nested Class
    /** Class to report a argument error. */
    public static class IllegalArgumentException extends Exception {
        /**
         * Construct a IllegalArgumentException with the specified
         * message.
         * @param message The message
         */
        IllegalArgumentException(String message) {
            super(message);
        }
    }
    // Nested Class
    /** Class to report a state error. */
    public static class IllegalStateException extends Exception {
        /**
         * Construct a IllegalStateException with the specified
         * message.
         * @param message The message
         */
        IllegalStateException(String message) {
            super(message);
        }
    }

    private E[] theArray;
    private int top1;
    private int top2;

    //Constructors
    /** Default constructor. */
    public DoubleStack() {
        theArray = (E[]) new Object[200];
        this.top1 = -1;
        this.top2 = theArray.length;
    }

    //Methods
    /** 
     * 
     * @param stackId Stack to push e onto
     * @param e Data being pushed on the stack
    */
    public void push(int stackId, E e) throws 
        IllegalArgumentException, IllegalStateException {
        if (stackId == 1) {
            top1++;
            if (top1 == top2) {
                throw new IllegalStateException(
                    "Invalid state encountered");
            }
            theArray[top1] = e;
        }
        else if (stackId == 2) {
            top2--;
            if (top2 == top1) {
                throw new IllegalStateException(
                    "Invalid state encountered");
            }
            theArray[top2] = e;
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }

    /**
     * Removes and returns topmost object of specified
     * stack.
     * @param stackId Stack to push e onto
     * @return Value popped from the stack
     */
    public E pop(int stackId) throws IllegalArgumentException {
        if (stackId == 1) {
            top1--;
            return theArray[top1 + 1];
        }
        else if (stackId == 2) {
            top2++;
            return theArray[top2 - 1];
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }

    /**
     * Returns topmost object of specified stack.
     * @param stackId Stack to push e onto
     * @return Value at the top
     */
    public E top(int stackId) throws IllegalArgumentException {
        if (stackId == 1) {
            return theArray[top1];
        }
        else if (stackId == 2) {
            return theArray[top2];
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }

    /**
     * Returns size of specified stack.
     * @param stackId Stack to push e onto
     * @return Int value of stack size
     */
    public int size(int stackId) throws IllegalArgumentException {
        if (stackId == 1) {
            return top1 + 1;
        }
        else if (stackId == 2) {
            return theArray.length - top2;
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }

    /**
     * Checks if specified stack is empty.
     * @param stackId Stack to push e onto
     * @return True if empty, false if not empty
     */
    public boolean isEmpty(int stackId) throws IllegalArgumentException {
        if (stackId == 1) {
            return top1 == -1;
        }
        else if (stackId == 2) {
            return top2 == theArray.length;
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }

    /**
     * Prints specified stack.
     * @param stackId Stack to push e onto
     * @return String of all values of specified stack
     */
    public String printStack(int stackId) throws IllegalArgumentException {
        String print = "";
        if (stackId == 1) {
            for (int i = 0; i < top1; i++) {
                print += theArray[i];
            }
            return print;
        }
        else if (stackId == 2) {
            for (int i = theArray.length - 1; i > top2; i--) {
                print += theArray[i];
            }
            return print;
        }
        else {
            throw new IllegalArgumentException(
                "Invalid stackId encountered");
        }
    }
}
