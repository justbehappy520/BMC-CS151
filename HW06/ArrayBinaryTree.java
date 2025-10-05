import java.util.Stack;

/**
 * A class that creates and modifies ArrayBinaryTrees.
 * 
 * @param <E> this class is templated
 */
public class ArrayBinaryTree<E extends Comparable<E>> 
    implements BinaryTree<E> {
    
    // instance variables
    /**
     * A protected instance variable to be used in ArrayBinaryTree
     * and ArrayHeap.
     */
    protected int numElem; // number of elements in ArrayBinaryTree
    private E[] elements; // array of elements

    // constructors
    /**
     * Default constructor for the ArrayBinaryTree class. The size
     * of the array defaults to 100 and the index of the first and
     * last element default to -1.
     */
    public ArrayBinaryTree() {
        this.numElem = 0;
        this.elements = (E[]) new Comparable[100];
    }

    /**
     * Customized constructor for the ArrayBinaryTree class. The 
     * size of the array is set by the user in the argument.
     * 
     * @param size is the user-set size of the ArrayBinaryTree
     */
    public ArrayBinaryTree(int size) {
        this.numElem = 0;
        this.elements = (E[]) new Comparable[size];
    }

    // methods
    /**
     * A method that returns the element at a given index.
     * 
     * @param index is the index who's element is to be returned
     * @return the element at the given index
     */
    public E get(int index) {
        return elements[index];
    }

    /**
     * A method that assigns a specific index with a given element.
     * 
     * @param index is the index where the element will be set
     * @param element is the element given
     */
    public void set(int index, E element) {
        elements[index] = element;
    }

    /**
     * A method that returns the index of the first element in the
     * ArrayBinaryTree.
     * 
     * @return an integer index of the first element
     */
    public E getRootElement() {
        if (isEmpty()) {
            return null;
        }
        else {
            return elements[0];
        }
    }

    /**
     * A method that returns the size of an ArrayBinaryTree.
     * 
     * @return an integer value of the number of elements in the
     * ArrayBinaryTree
     */
    public int size() {
        return numElem;
    }

    /**
     * A method that returns a boolean depending on whether the
     * ArrayBinaryTree is empty.
     * 
     * @return true if the ArrayBinaryTree is empty, false if otherwise
     */
    public boolean isEmpty() {
        return numElem == 0;
    }

    /**
     * A method to calculate the index of the parent of a given child.
     * 
     * @param i is the index of the given child
     * @return an integer index of the parent
     */
    public int parent(int i) {
        int parentIdx = -1; // index of the parent of a given child
        // -1 is default value for empty parentIdx

        if (i % 2 == 0) {
            // index of all right children are even
            parentIdx = (i - 2) / 2;
            return parentIdx;
        }
        else {
            // index of all left children are odd
            parentIdx = (i - 1) / 2;
        }

        return parentIdx;
    }

    /**
     * A method to calculate the index of the left child of a given
     * parent.
     * 
     * @param i is the index of the parent
     * @return an integer index of the left child
     */
    public int left(int i) {
        int leftIdx; // index of the left child of a given parent
        leftIdx = (2 * i) + 1;
        return leftIdx;
    }

    /**
     * A method to calculate the index of the right child of a given
     * parent.
     * 
     * @param i is the index of the parent
     * @return an integer index of the right child
     */
    public int right(int i) {
        int rightIdx; // index of the right child of a given parent
        rightIdx = (2 * i) + 2;
        return rightIdx;
    }

    /**
     * A method that swaps the elements at two given indices on the
     * ArrayBinaryTree.
     * 
     * @param i is the index of one of the elements to be swapped
     * @param j is the index of one of the elements to be swapped
     */
    public void swap(int i, int j) {
        E tmp; // temporary int to hold one of the values

        if (i < numElem && j < numElem) {
            tmp = elements[i];
            elements[i] = elements[j];
            elements[j] = tmp;
        }
    }

    /**
     * A method that returns the index of an element in the
     * ArrayBinaryTree if the element matches the given element.
     * 
     * @param element is the element to search for
     * @return an integer index of the given element
     */
    public int containsIdx(E element) {
        int idx = -1; // index containing element

        for (int i = 0; i < elements.length; i++) {
            // loop through the array until the index with an element
            // matching the given element is found
            if (elements[i] != null &&
                elements[i].compareTo(element) == 0) {
                idx = i;
                return idx;
            }
        }
        return idx;
    }

    /**
     * A method that checks the ArrayBinaryTree for a given element.
     * 
     * @param element is the data being checked for
     * @return true if element exists, false if not
     */
    public boolean contains(E element) {
        boolean contains = false;
        if (containsIdx(element) > -1) {
            contains = true;
            return contains;
        }
        return contains;
    }

    /**
     * A method that inserts new element into the ArrayBinaryTree.
     * Insertion of existing elements replaces the current element,
     * think updating. Uses the compareTo method.
     * 
     * @param element is the data being inserted
     */
    public void insert(E element) {
        // base case
        if (isEmpty()) {
            elements[0] = element;
            numElem++;
            return;
        }

        // insert element into index after last
        int elemIdx = numElem;
        elements[elemIdx] = element;
        numElem++;
    }

    /**
     * A method that removes the given element, patches the
     * space left by the removed element, then returns a boolean
     * depending on whether or not the element has been removed.
     * 
     * @param element is the element that is to be removed
     * @return true if the element is found and removed, false if
     * otherwise
     */
    public boolean remove(E element) {
        boolean removed = false;
        int index = containsIdx(element);
        if (index == -1) {
            return removed;
        }
        // replace to be removed w/ last element
        elements[index] = elements[numElem - 1];
        numElem--;
        removed = true;
        return removed;
    }

    // toString methods to print the ArrayBinaryTree
    /**
     * A method that returns a current snapshot of the tree.
     * 
     * @return a String of the data in the LinkedBinaryTree
     * first in pre-order traversal, then in in-order
     * traversal, finally in post-order traversal
     */
    @Override
    public String toString() {
        String preOrder = toStringPreOrder() + "\n";
        String inOrder = toStringInOrder() + "\n";
        String postOrder = toStringPostOrder() + "\n";
        return "\nTree:\n" + preOrder + inOrder + postOrder;
    }

    /**
     * A method that prints the ArrayBinaryTree according to
     * In-Order Traversal (i.e., left, root, right - a b c).
     * 
     * @return a String of the elements in the ArrayBinaryTree
     * in in-order traversal order
     */
    public String toStringInOrder() {
        if (isEmpty()) {
            return null;
        }
        return "In: " + inOrderTraversal(getRootElement());
    }

    /**
     * A method that returns a String of elements in the 
     * ArrayBinaryTree according to in-order traversal.
     * toStringInOrder() helper method.
     * 
     * @param node is the node to start with
     * @return a String of the elements in the ArrayBinaryTree
     * in in-order traversal order
     */
    private String inOrderTraversal(E element) {
        // the string to return
        String inOrder = "";

        // base case
        if (isEmpty()) {
            return "";
        }

        // using a stack to run through in-order traversal
        Stack<Integer> stack = new Stack<>();
        int index = 0; // start at root

        // traverse the tree until the stack has nothing
        // or until the current index is null
        while (!stack.isEmpty() || elements[index] != null) {
            // traverse down to the leftmost leaf
            while (index != -1 && index < numElem) {
                stack.push(index);
                index = left(index);
                // put all the left children into the stack
            }

            if (!stack.isEmpty()) {
                // pop from stack and append to string
                index = stack.pop();
                inOrder += elements[index] + " ";
                // go back to push more into stack if there is
                // a right child
                index = right(index);
            }
        }
        // trim to remove trailing spacese
        return inOrder.trim();
    }

    /**
     * A method that prints the ArrayBinaryTree according to
     * Pre-Order Traversal (i.e., root, left, right - b a c).
     * 
     * @return a String of the elements in the ArrayBinaryTree
     * in pre-order traversal order
     */
    public String toStringPreOrder() {
        if (isEmpty()) {
            return null;
        }
        return "Pre: " + preOrderTraversal(getRootElement());
    }

    /**
     * A method that returns a String of elements in the
     * ArrayBinaryTree according to pre-order traversal.
     * toStringPreOrder() helper method.
     * 
     * @param element is the element to start with
     * @return a String of the elements in the ArrayBinaryTree
     * in pre-order traversal order
     */
    private String preOrderTraversal(E element) {
        // the string to return
        String preOrder = "";

        // base case
        if (isEmpty()) {
            return "";
        }

        // using a stack to run through in-order traversal
        Stack<Integer> stack = new Stack<>();
        int index = 0; // start at root

        // traverse the tree until the stack has nothing
        // or until the current index is null
        while (!stack.isEmpty() || elements[index] != null) {
            // traverse down to the leftmost leaf
            while (index != -1 && index < numElem) {
                // put the root in
                preOrder += elements[index] + " ";
                stack.push(index);
                index = left(index);
                // put all the left children into the stack
            }

            // has a right child
            if (!stack.isEmpty()) {
                index = stack.pop();
                index = right(index);
            }
        }
        // trim to remove trailing spacese
        return preOrder.trim();
    }

    /**
     * A method that prints the ArrayBinaryTree according to
     * Post-Order Traversal (i.e., left, right, root - a c b).
     * 
     * @return a String of the elements in the ArrayBinaryTree
     * in post-order traversal order
     */
    public String toStringPostOrder() {
        if (isEmpty()) {
            return null;
        }
        return "Post: " + postOrderTraversal(0);
    }

    /**
     * A method that returns a String of elements in the
     * ArrayBinaryTree according to post-order traversal.
     * toStringPostOrder() helper method.
     * 
     * @param index is the index to start with
     * @return a String of the elements in the ArrayBinaryTree
     * in post-order traversal order
     */
    public String postOrderTraversal(int index) {
        // the String to be returned
        String postOrder = "";

        // base case
        if (isEmpty()) {
            return "";
        }

        // recursion because I gave up trying to make a stack work
        if (index < numElem) {
            postOrder += postOrderTraversal(left(index));
            postOrder += postOrderTraversal(right(index));
            postOrder += elements[index] + " ";
        }
        return postOrder;
    }

    /**
     * A method that concatenates the elements of the
     * ArrayBinaryTree into a String and prints out the String.
     * 
     * @return a String with the elements of the ArrayBinaryTree
     * in breadth first order
     */
    public String toStringBreadthFirst() {
        String printBread = "";
        if (isEmpty()) {
            return printBread;
        }

        for (int i = 0; i < numElem - 1; i++) {
            printBread += elements[i] + " ";
        }
        printBread += elements[numElem - 1];
        return printBread;
    }
}
