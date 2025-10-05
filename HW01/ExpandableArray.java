public class ExpandableArray<E> {
    private E[] array;
    private int numElements;
    
    public ExpandableArray(int size) {
        array = (E[]) new Object[size];
    }

    public ExpandableArray() {
        array = (E[]) new Object[2];
    }

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

    public E[] insert(E item, int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid. Please try again.");
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

    public E get(int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid. Please try again.");
        }
        return array[index];
    }

    public E remove(int index) {
        if (index >= array.length) {
            System.out.println("Your index is out of bounds. Please try again.");
        }
        if (index > numElements) {
            System.out.println("Your index is invalid. Please try again.");
        }
        E item = array[index];

        for (int i = index + 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
        numElements--;
        return item;
    }

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

    public void set(E item, int index) {
        array[index] = item;
    }

    public int size() {
        return numElements;
    }
}
