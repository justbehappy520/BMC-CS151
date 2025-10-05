import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that creates an ArrayHeap.
 * 
 * @param <E> this class is templated
 */
public class ArrayHeap<E extends Comparable<E>> 
    extends ArrayBinaryTree<E> 
    implements PriorityQueue<E> {
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

        // start searching, check if element already exists
        int index = containsIdx(element);
        if (index != -1) {
            // exists!! update
            set(index, element);
            downHeap(index);
        }
        else {
            // does not exist
            set(numElem, element);
            numElem++;
            upHeap(numElem - 1);
        }
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
            get(parent(index))) > 0) {
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
        int max = index;
        
        if (leftIdx < numElem && get(leftIdx).compareTo(
            get(max)) > 0) {
            max = leftIdx;
        }
        if (rightIdx < numElem && get(rightIdx).compareTo(
            get(max)) > 0) {
            max = rightIdx;
        }

        if (max != index) {
            swap(index, max);
            downHeap(max);
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
    public String toString() {
        String printBread = "";
        if (isEmpty()) {
            return printBread;
        }

        // the first level only has one element
        int levelSize = 1;
        int levelIndex = 0;
        for (int i = 0; i < numElem; i++) {
            if (levelIndex < levelSize - 1) {
                printBread += get(i) + " ";
            }
            levelIndex++;
            if (levelIndex == levelSize) {
                printBread += get(i);
                printBread += "\n";
                levelIndex = 0;
                // difference in size of each level is prev * 2
                levelSize *= 2;
            }
        }
        return printBread.strip();
    }

    /**
     * A method that returns the root of the ArrayHeap.
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
     * A method that returns the the root of the ArrayHeap.
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

    /**
     * A method that returns the top n number of elements of 
     * the ArrayHeap in order. If the ArrayHeap has less than
     * n elements, return all the elements in the ArrayHeap
     * in descending order.
     * 
     * @param n is the number of elements to return
     * @return an ArrayList of elements from the ArrayHeap
     */
    public ArrayList<E> peekTopN(int n) {
        // base case
        if (isEmpty() || n <= 0) {
            return new ArrayList<>();
        }

        ArrayList<E> list = new ArrayList<>();
        
        if (numElem < n) {
            for (int i = 0; i < numElem; i++) {
                list.add(get(i));
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                list.add(get(i));
            }
        }

        return list;
    }

    // PollingData specific methods
    /**
     * A method that returns the index of an element in the
     * ArrayBinaryTree if the element matches the given element.
     * 
     * @param element is the element to search for
     * @return an integer index of the given element
     */
    public int containsIdx(PollingData element) {
        int idx = -1; // index containing element

        for (int i = 0; i < numElem; i++) {
            // loop through the array until the index with an element
            // matching the given element is found
            if (get(i) != null &&
                ((PollingData) get(i)).compareLastName(element) == 0) {
                idx = i;
                return idx;
            }
        }
        return idx;
    }


    /**
     * Parses a line from the csv and returns a PollingData
     * object with the information from the line.
     * 
     * @param line is the line with information to parse
     * from the csv file
     * @return a PollingData object with the information parsed 
     * from the line
     */
    public PollingData parseLine(String line) {
        // split the information in the line
        String[] input = line.split(",");
        
        // extract relevant data
        String lastName = input[0];
        String fullName = input[1];
        double percent = Double.parseDouble(input[2]);
        //System.out.println(percent);

        // create and return PollingData
        PollingData data = new PollingData(lastName, fullName, percent);
        return data;
    }

    /**
     * Reads in a line from the given csv file and parses the
     * data into a ArrayBinaryTree.
     * 
     * @param filename is the name of the file to read
     * @throws FileNotFoundException if file is not found
     */
    public void readData(String filename) throws FileNotFoundException {
        // scan in a file
        Scanner input = new Scanner(new File(filename));
        String nextLine; // next line of input
        PollingData data; // PollingData object

        // skip the first
        input.nextLine();

        // read and parse data
        while (input.hasNextLine()) {
            nextLine = input.nextLine();
            data = parseLine(nextLine);

            // insert object into ArrayBinaryTree
            insert((E) data);
        }
        input.close();
    }
}
