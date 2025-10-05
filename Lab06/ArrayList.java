/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *      Data Structures and Algorithms in Java, Sixth Edition
 *      Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *      John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Realization of a list by means of a dynamic array. 
 * This is a simplified version
 * of the java.util.ArrayList class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 *
 * @param <E> ArrayList can store any generic types
 */
public class ArrayList<E> implements List<E> {
    // instance variables
    /** Default array capacity. */
    public static final int CAPACITY = 16; // default array capacity

    /** Generic array used for storage of list elements. */
    private E[] data; // generic array used for storage

    /** Current number of elements in the list. */
    private int size; // current number of elements

    // constructors
    /** Creates an array list with default initial capacity. */
    // constructs list with default capacity
    public ArrayList() { 
        this(CAPACITY);
        this.size = 0;
    }   

    /** Creates an array list with given initial capacity. 
     * @param capacity the maximum number of elements the
     *   Array can store
    */
    @SuppressWarnings({"unchecked"})
    // constructs list with given capacity
    public ArrayList(int capacity) {                 
        // safe cast; compiler may give warning
        data = (E[]) new Object[capacity];
        this.size = 0;  
    }

    // public methods
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    public int size() { 
        return size; 
    }

    /**
     * Tests whether the array list is empty.
     * @return true if the array list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the element at index i.
     * @param  i the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is 
     *  negative or greater than size()-1
     */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at the specified index, and 
     *  returns the element previously stored.
     * @param  i the index of the element to replace
     * @param  e the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is 
     *  negative or greater than size()-1
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts the given element at the specified index of the list, 
     *  shifting all subsequent elements in the list one position 
     *  further to make room.
     * @param  i the index at which the new element should be stored
     * @param  e the new element to be stored
     * @throws IndexOutOfBoundsException if the index 
     *  is negative or greater than size()
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) { // not enough capacity
            resize(2 * data.length); // so double the current capacity
        }
        for (int k = size - 1; k >= i; k--) { // start by shifting rightmost
            data[k + 1] = data[k];
        }
        data[i] = e; // ready to place the new element
        size++;
    }

    /**
     * Removes and returns the element at the given index, 
     *  shifting all subsequent elements in the list 
     *  one position closer to the front.
     * @param  i the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException 
     *  if the index is negative or greater than size()
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) { // shift elements to fill hole
            data[k] = data[k + 1];
        }
        data[size - 1] = null;  // help garbage collection
        size--;
        return temp;
    }

    // utility methods
    /** Checks whether the given index is in the range [0, n-1]. 
     * @param  i  the index to check
     * @param  n  the max in the range
     * @throws IndexOutOfBoundsException 
     *  if the index is greater than the max
    */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /** Resizes internal array to have given capacity >= size. 
     * @param capacity the maximum number of elements the
     *   Array can store after it is resized
    */
    @SuppressWarnings({"unchecked"})
    protected void resize(int capacity) {
        // safe cast; compiler may give warning
        E[] temp = (E[]) new Object[capacity];       
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;  // start using the new array
    }

    //---------------- nested ArrayIterator class ----------------
    /**
     * A (nonstatic) inner class. 
     *   Note well that each instance contains an implicit
     * reference to the containing list, 
     *   allowing it to access the list's members.
     */
    private class ArrayIterator implements Iterator<E> {
        /** Index of the next element to report. */
        // index of the next element to report
        private int j;                                   
        // can remove be called at this time?
        private boolean removable;   

        /**
         * Tests whether the iterator has a next object.
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext() { 
            // size is field of outer instance
            return j < size; 
        }

        /**
         * Returns the next object in the iterator.
         *
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            // this element can subsequently be removed
            removable = true;       
            // post-increment j, so it is ready for future call to next
            return data[j++]; 
        }

        /**
         * Removes the element returned by most recent call to next.
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove 
              was already called since recent next
         */
        public void remove() throws IllegalStateException {
            if (!removable) {
                throw new IllegalStateException("nothing to remove");
            }
            ArrayList.this.remove(j - 1);  // that was the last one returned
            j--;     // next element has shifted one cell to the left
            removable = false; // do not allow remove again until next is called
        } 
    } //------------ end of nested ArrayIterator class ------------

    /**
     * Returns an iterator of the elements stored in the list.
     * @return iterator of the list's elements
     */
    @Override
    public Iterator<E> iterator() {
        // create a new instance of the inner class
        return new ArrayIterator();         
    }

    /**
     * Produces a string representation of the contents of the indexed list.
     * This exists for debugging purposes only.
     *
     * @return textual representation of the array list
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        for (int j = 0; j < size; j++) {
            if (j > 0) {
                sb.append(", ");
            }
            sb.append(data[j]);
        }
        sb.append(")");
        return sb.toString();
    }

    //---------------- nested MyListIterator class ----------------
    public class MyListIterator implements MyIterator<E> {
        /** Index of the next element to report. */
        // index of the next/previous element to report
        private int j;                    
        // can remove be called at this time?
        private boolean removableNext;
        private boolean removablePrev;
        // has next just been called?
        private boolean next;
        // has previous just been called?
        private boolean prev;

        /**
         * Tests whether the iterator has a next object.
         * @return true if there are further objects, false otherwise
         */
        public boolean hasNext() { 
            // size is field of outer instance
            return j < size; 
        }

        /**
         * Returns the next object in the iterator.
         *
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            // this element can subsequently be removed
            removableNext = true;
            removablePrev = false;
            // this element can have something set in its place
            next = true;
            // post-increment j, so it is ready for future call to next
            return data[j++]; 
        }

        /**
         * Tests whether the iterator has a previous object.
         * @return true if there are further objects, false otherwise
         */
        public boolean hasPrevious() { 
            // 0 is the first element
            return j > 0; 
        }

        /**
         * Returns the previous object in the iterator.
         *
         * @return previous object
         * @throws NoSuchElementException if there are no previous elements
         */
        public E previous() throws NoSuchElementException {
            if (j <= 0) {
                throw new NoSuchElementException("No previous element");
            }
            // this element can subsequently be removed
            removablePrev = true;
            removableNext = false;
            // this element can have something set in its place
            prev = true;
            // post-decrement k, so it is ready for future call to previous
            return data[--j];
        }

        /**
         * Removes the element returned by most recent call to next
         *  or previous.
         * @throws IllegalStateException if next/previous has not yet 
         *  been called
         * @throws IllegalStateException if remove was already 
         *  called since recent next/previous
         */
        public void remove() throws IllegalStateException {
            if (!removableNext && !removablePrev) {
                throw new IllegalStateException("nothing to remove");
            }
            
            if (removableNext) {
                ArrayList.this.remove(j - 1); // that was the last one returned
                j--; // next element has shifted one cell to the left
                // do not allow remove again until next is called
                removableNext = false;
            }
            else if (removablePrev) {
                ArrayList.this.remove(j); // that was the last one returned
                // do not allow remove again until next is called
                removablePrev = false;
            }
        }

        /**
         * Replaces the last element returned by {@link #next} or 
         * {@link #previous} with the specified element. This method can be
         * called only if {@link #remove} has not been called after the last
         * call to {@link #next} {@link #previous}. This method can be called
         * only once per call to or {@link #next} or {@link #previous}. The 
         * behavior of an iterator is unspecified if the underlying collection 
         * is modified while the iteration is in progress in any way other 
         * than by calling this method.
         *
         * @param e the specified element
         * @throws IllegalStateException if the {@code previous} or 
         *         {@code next} method has not yet been called, or
         *         the {@code remove} method has already been called
         *         after the last call to the {@code previous} or
         *         {@code next} method
         */
        public void set(E e) throws IllegalStateException {
            if (!removableNext && !removablePrev) {
                throw new IllegalStateException("something's wrong");
            }
            
            if (removableNext) {
                ArrayList.this.set(j - 1, e); // that was the last one returned
                // do not allow set again until next is called
                removableNext = false; 
            }
            else if (removablePrev) {
                ArrayList.this.set(j, e);  // that was the last one returned
                // do not allow set again until prev is called
                removablePrev = false; 
            }
        }
    } //------------ end of nested MyListIterator class ------------

    /**Method to construct a MyListIterator.
     * 
     * @return MyListIterator
     */
    public MyListIterator myListIterator() {
        return new MyListIterator();
    }
    /**method to construct a MyListIterator at set index.
     * 
     * @param i Index before which to construct a MyListIterator
     * @return MyListIterator
     */

    public MyListIterator myListIterator(int i) {
        MyListIterator itr = new MyListIterator();

        for (; i > 0; i--) {
            itr.next();
        }

        return itr;
    }

    /**Method to remove elements in L at indices set in P.
     * 
     * @param <E> generic
     * @param elem ArrayList with elements to be removed
     * @param indices ArrayList with indices of elements to be removed
     */
    public static <E> void removePositions(ArrayList<E> elem,
        ArrayList<Integer> indices) {
        int index = 0; // keep track of current position
        MyIterator<E> itrL = elem.myListIterator();

        while (itrL.hasNext()) {
            itrL.next();

            // iterate through P to check if there's a match
            for (int i = 0; i < indices.size(); i++) {
                // check if there's a match
                if (indices.get(i) == index) {
                    itrL.remove();
                }
            }
            // increment for next iteration
            index++;
        }
    }
}
