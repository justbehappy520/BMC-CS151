/**Class to create an array with no size limitation. 
 * @param <E> allows templating to this method
 */
public class ExpandableArray<E> {
    private E[] array;
    private int numElements;
    
    /**Constructor with set size. 
     * @param size user set size of array
     */
    public ExpandableArray(int size) {
        array = (E[]) new Object[size];
    }

    /**Default constructor. */
    public ExpandableArray() {
        array = (E[]) new Object[2];
    }

    /**Inserts a given item.
     * 
     * @param item Element to be inserted
     * @return Array with item inserted
     */
    public E[] insert(E item) {
        if (numElements == array.length) {
            E[] arrayOld = array;
            array = (E[]) new Object[array.length * 2];
            for (int i = 0; i < arrayOld.length; i++) {
                array[i] = arrayOld[i];
            }
        }
        E temp1 = item;
        E temp2;
        for (int i = 0; i < array.length; i++) {
            temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        }

        numElements++;
        return array;
    }

    /**Inserts a given item at a given index.
     * 
     * @param item New item to be inserted
     * @param index Index to insert item
     * @return Array of items with the new items set in
     */
    public E[] insert(E item, int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. " + 
                "Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid. Please " +
                "try again.");
        }
        if (numElements == array.length) {
            E[] arrayOld = array;
            array = (E[]) new Object[array.length * 2];
            for (int i = 0; i < arrayOld.length; i++) {
                array[i] = arrayOld[i];
            }
        }
        
        E temp1 = item;
        E temp2;
        for (int i = index; i < array.length; i++) {
            temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        }
        numElements++;
        return array;
    }

    /**Returns the item at a given index.
     * 
     * @param index The index from which to take the item from.
     * @return The item at the given index.
     */
    public E get(int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. " + 
                "Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid." + 
                "Please try again.");
        }
        return array[index];
    }

    /**Removes and returns an item at a given index.
     * 
     * @param index The index of the element to be removed.
     * @return The element removed
     */
    public E remove(int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. "
                + "Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid. " +
                "Please try again.");
        }
        E item = array[index];

        for (int i = index + 1; i < array.length; i++) {
            array[i - 1] = array[i];
        }
        numElements--;
        return item;
    }

    /**Returns a string of a Place.
     * 
     * @return String of information about a place
     */
    public String toString() {
        String printArray = "";
        if (numElements > 0) {
            for (int i = 0; i < numElements; i++) {
                if (i == numElements - 1) {
                    printArray += array[i];
                    return printArray;
                }
                printArray += array[i] + ", ";
            }
        }
    
        return printArray;
    }

    /**Sets a specific index with the given element.
     * 
     * @param item The new element being introduced
     * @param index The index where the set will happen
     */
    public void set(E item, int index) {
        array[index] = item;
    }

    /**Returns the size of the array.
     * 
     * @return Integer size of aray
     */
    public int size() {
        return numElements;
    }
}