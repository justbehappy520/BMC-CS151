import java.util.ArrayList;

/**
 * A class that extends ArrayBinaryTree and implements
 * LabPriorityQueue.
 * 
 * @param <E> this class is templated
 */
public class ArrayHeap<E extends Comparable<E>> extends 
    ArrayBinaryTree<E> implements LabPriorityQueue<E> {

    // instance variables
    private ArrayBinaryTree<E> binaryTree;

    // constructors
    /**
     * Default constructor for ArrayHeap.
     */
    public ArrayHeap() {
        binaryTree = new ArrayBinaryTree<>();
    }

    /**
     * A method that returns the index of the first element in the
     * ArrayHeap.
     * 
     * @return an integer index of the first element
     */
    @Override
    public E getRootElement() {
        if (isEmpty()) {
            return null;
        }
        else {
            return get(0);
        }
    }
    
    /**
     * A method that returns the size of an ArrayHeap.
     * 
     * @return an integer value of the number of elements in the
     * ArrayHeap
     */
    @Override
    public int size() {
        return numElem;
    }

    /**
     * A method that returns a boolean depending on whether the
     * ArrayHeap is empty.
     * 
     * @return true if the ArrayHeap is empty, false if otherwise
     */
    @Override
    public boolean isEmpty() {
        return numElem == 0;
    }

    /**
     * A method that inserts the given element.
     * 
     * @param element is the element that is to be inserted
     */
    @Override
    public void insert(E element) {
        // base case
        if (isEmpty()) {
            set(0, element);
            numElem++;
            return;
        }

        set(numElem, element);
        numElem++;
        upHeap(numElem - 1);
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
    @Override
    public boolean remove(E element) {
        int index = containsIdx(element);
        if (index == -1) {
            return false;
        }
        // replace to be removed w/ last element
        set(index, get(numElem - 1));
        numElem--;

        // maintain completeness
        upHeap(index);
        downHeap(index);

        return true;
    }


    /**
     * A hepler method for remove.
     * 
     * @param index is the index of the element to be upHeaped
     */
    private void upHeap(int index) {
        while (index > 0 && get(index).compareTo(
            get(parent(index))) < 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /**
     * A helper method for remove.
     * 
     * @param index is the index of the element to be downHeaped
     */
    private void downHeap(int index) {
        int leftIdx = left(index);
        int rightIdx = right(index);
        int min = index;
        
        if (leftIdx < numElem && get(leftIdx).compareTo(
            get(min)) < 0) {
            min = leftIdx;
        }
        if (rightIdx < numElem && get(rightIdx).compareTo(
            get(min)) < 0) {
            min = rightIdx;
        }

        if (min != index) {
            swap(index, min);
            downHeap(min);
        }
    }

    /**
     * A method that concatenates the elements of the
     * ArrayHeap into a String and prints out the String.
     * 
     * @return a String with the elements of the ArrayHeap
     * in breadth first order
     */
    @Override
    public String toStringBreadthFirst() {
        String printBread = "";
        if (isEmpty()) {
            return printBread;
        }

        for (int i = 0; i < numElem - 1; i++) {
            printBread += get(i) + " ";
        }
        printBread += get(numElem - 1);
        return printBread;
    }

    /**
     * A method that returns the minimum element in the ArrayHeap.
     * 
     * @return the root
     */
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return getRootElement();
    }

    /**
     * A method that returns the smallest element (the root) of
     * the ArrayHeap.
     * 
     * @return the root
     */
    public E poll() {
        E poll = get(0);
        if (remove(poll)) {
            return poll;
        }
        return null;
    }

    public char[] toStringPeek(int numVar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toStringPeek'");
    }

    public int peakTopN(int numVar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peakTopN'");
    }

    public void readData(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readData'");
    }

    public ArrayList<PollingData> peekTopN(int topN) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peekTopN'");
    }

    public static char[] topNString(ArrayList<PollingData> data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'topNString'");
    }
}
