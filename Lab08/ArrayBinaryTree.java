/**
 * A class that implements the LabBinaryTree to create
 * ArrayBinaryTrees. ArrayBinaryTrees are binary trees implemented
 * on an array.
 * 
 * @param <E> this class is templated
 */
public class ArrayBinaryTree<E extends Comparable<E>> implements
    LabBinaryTree<E> {
    
    // instance variables
    protected int numElem; // number of elements in the ArrayBinaryTree
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
     * A method that inserts the given element.
     * 
     * @param element is the element that is to be inserted
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

    /**
     * Main method of the ArrayBinaryTree class. Tests the 
     * ArrayBinaryTree class by creating an ArrayBinaryTree object,
     * inserting integers 1-20 into the tree, and then using
     * toStringBreadthFirst() to print out the object.
     * 
     * @param args is a String[] who takes input from the command-
     * line
     */
    public static void main(String[] args) {
        ArrayBinaryTree<Integer> shu4 = new ArrayBinaryTree<>();
        shu4.insert(1);
        shu4.insert(2);
        shu4.insert(3);
        shu4.insert(4);
        shu4.insert(5);
        shu4.insert(6);
        shu4.insert(7);
        shu4.insert(8);
        shu4.insert(9);
        shu4.insert(10);
        shu4.insert(11);
        shu4.insert(12);
        shu4.insert(13);
        shu4.insert(14);
        shu4.insert(15);
        shu4.insert(16);
        shu4.insert(17);
        shu4.insert(18);
        shu4.insert(19);
        shu4.insert(20);

        System.out.println(shu4.toStringBreadthFirst());
    }
}
