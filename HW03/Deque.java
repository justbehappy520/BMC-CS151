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
//package net.datastructures;

/**
 * A collection of objects that are inserted and removed according to the 
 * first-in first-out principle. Although similar in purpose, this interface 
 * differs from java.util.Deque.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 * @param <E> - supports generics
 */
public interface Deque<E> {

    /**
     * Returns the number of elements in the dequeu.
     * @return number of elements in the dequeu
     */
    int size();

    /**
     * Tests whether the dequeu is empty.
     * @return true if the dequeu is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns, but does not remove, the first element of the dequeu.
     * @return top element in the dequeu (or null if empty)
     */
    E first();

    /**
     * Returns, but does not remove, the last element of the dequeu.
     * @return top element in the dequeu (or null if empty)
     */
    E last();

    /**
     * Inserts an element at the front of the dequeu.
     * @param e the element to be inserted
     */
    void addFirst(E e);

    /**
     * Inserts an element at the back of the dequeu.
     * @param e the element to be inserted
     */
    void addLast(E e);

    /**
     * Removes and returns the first element of the dequeu (null if empty).
     * @return the first element in the dequeu (or null if empty)
     */
    E removeFirst();

    /**
     * Removes and returns the last element of the dequeu (null if empty).
     * @return the last element in the dequeu (or null if empty)
     */
    E removeLast();
}
