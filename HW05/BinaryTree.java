/**
 * A class to be implemented with a bunch of methods to
 * create a binary tree.
 * 
 * @param <E> generic yayHW05/BinaryTree.java
 */
public interface BinaryTree<E extends Comparable<E>> {
    /**
     * Returns the root element of the LinkedBinaryTree.
     * 
     * @return the element of the root
     */
    E getRootElement();

    /**
     * Returns the size of the LinkedBinaryTree.
     * 
     * @return the number of elements in the tree
     */
    int size();

    /**
     * Checks if the LinkedBinaryTree has any elements.
     * 
     * @return true if there are no elements, false if 
     * there are elements
     */
    boolean isEmpty();

    /**
     * Checks the LinkedBinaryTree for a given element.
     * 
     * @param element is the data being checked for
     * @return true if element exists, false if not
     */
    boolean contains(E element);

    /**
     * Inserts new element into the LinkedBinaryTree.
     * Insertion of existing elements replaces the current 
     * element, think updating. Uses the compareTo method.
     * 
     * @param element is the data being inserted
     */
    void insert(E element);

    /**
     * Checks if a given element exists in the
     * LinkedBinaryTree and is removed.
     *  
     * @param element is the data being checked and removed
     * @return true if the element previously exists and is
     * removed, false if otherwise
     */
    boolean remove(E element);

    /**
     * Returns a current snapshot of the tree.
     * 
     * @return a String of the data in the LinkedBinaryTree
     * first in pre-order traversal, then in in-order
     * traversal, finally in post-order traversal
     */
    String toStringInOrder();

    /**
     * Prints the LinkedBinaryTree according to Pre-Order 
     * Traversal (i.e., root, left, right - b a c).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in pre-order traversal order
     */
    String toStringPreOrder();

    /**
     * Prints the LinkedBinaryTree according to Post-Order 
     * Traversal (i.e., left, right, root - a c b).
     * 
     * @return a String of the elements in the LinkedBinaryTree
     * in post-order traversal order
     */
    String toStringPostOrder();
}